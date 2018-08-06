#!/usr/bin/python

import os
import re
from mininet.net import Mininet
from mininet.topo import Topo
from mininet.node import RemoteController, UserSwitch, Host, Switch
from mininet.link import TCLink
from mininet.log import setLogLevel
from mininet.cli import CLI

class LeafSpine(Topo):
    def build(self, **_opts ):
        "Create Leaf and Spine Topo."
        #Topo.__init__(self)

       
	# Add hosts and switches
        Host1 = self.addHost( 'h1',ip='10.3.1.1' )
        Host2 = self.addHost( 'h2',ip='10.3.1.2' )
	Host3 = self.addHost( 'h3',ip='10.3.1.3' )
	Host4 = self.addHost( 'h4',ip='10.3.1.4' )
	Host5 = self.addHost( 'h5',ip='10.3.1.5' )
		
        p1 = self.addSwitch( 'p1' )
        p2 = self.addSwitch( 'p2' )
	p3 = self.addSwitch( 'p3' )
	p4 = self.addSwitch( 'p4' )
	p5 = self.addSwitch( 'p5' )
		
	ap15 = self.addSwitch( 'ap15' )
	ap25 = self.addSwitch( 'ap25' )
	ap35 = self.addSwitch( 'ap35' )
	ap45 = self.addSwitch( 'ap45' )

	#switch between hosts
	p12 = self.addSwitch( 'p12' )
	p13 = self.addSwitch( 'p13' )
	p34 = self.addSwitch( 'p34' )
	p24 = self.addSwitch( 'p24' )
		
        # Add links to host switches
        self.addLink( Host1, p1 )
        self.addLink( Host2, p2 )
	self.addLink( Host3, p3 )
	self.addLink( Host4, p4 )
	self.addLink( Host5, p5 )
		
	#add link to grid to junction switch
	self.addLink( p1, ap15 )
        self.addLink( p2, ap25 )
	self.addLink( p3, ap35 )
        self.addLink( p4, ap45 )
		
	# Add links to junctiom to junction switch
	self.addLink( ap15, p5 )
	self.addLink( ap25, p5 )
	self.addLink( ap35, p5 )
	self.addLink( ap45, p5 )
	
	#links to grids hosts

        self.addLink(p1,p12)
	self.addLink(p12,p2)
	self.addLink(p1,p13)
	self.addLink(p13,p3)
        self.addLink(p3,p34)
        self.addLink(p34,p4)
        self.addLink(p2,p24)
 	self.addLink(p24,p4)
        
	
       


class IpHost(Host):
    def __init__(self, name, gateway, *args, **kwargs):
        super(IpHost, self).__init__(name, *args, **kwargs)
        


def create():
    controllers = ['172.17.0.2']
    topo = LeafSpine()
    
    net = Mininet(topo=topo, link=TCLink, build=False,
                  switch=UserSwitch,
                  controller = None,
                  autoSetMacs = True)
    
    for i in range(len(controllers)):
        net.addController("c%s" % i , controller=RemoteController, ip=controllers[i])
    
    net.build()
    net.start()
    CLI(net)
    net.stop()

if __name__ == '__main__':
    setLogLevel('info')
    create()
    os.system('sudo mn -c')


topos = {
    'leaf': LeafSpine
}

