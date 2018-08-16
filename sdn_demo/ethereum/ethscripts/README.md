Read http://chainskills.com/2017/03/10/part-3-setup-the-private-chain-miners/
do the basic setup to use the genesis.json file to initialize ethereum at ~/ethereum/localnetwork

Then run ./gethlocalnet.sh

This will start geth at http://localhost:8545

Now run ./gradlew build

The tests will run against the local ethereum network
