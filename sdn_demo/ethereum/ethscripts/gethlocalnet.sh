#!/bin/bash
# Use this to start a local geth network which will mine blocks and act as a test server at http://localhost:8545
WORKDIR=~/ethereum/localnetwork
mkdir -p $WORKDIR
echo "12341234" >> $WORKDIR/password.sec
geth --identity "miner1" --networkid 42 --datadir "$WORKDIR" --mine --rpc --rpcport "8545" --port "30303" --unlock 0 --password $WORKDIR/password.sec --ipcpath "~/geth.ipc" --rpcapi "web3,eth,net,debug,personal" --rpccorsdomain "*" --rpcaddr "0.0.0.0"
