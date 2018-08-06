
py net.addHost('h6')
py net.addLink(p5,net.get('h6'))
py p5.attach('p5-eth6')
py net.get('h6').setIP('10.3.1.6')
h1 ping h6
py ap15.stop()
link p1 h1 down
h2 ping h6
link p2 h2 down
h3 ping h6



