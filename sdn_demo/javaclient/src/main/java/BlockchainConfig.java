import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class BlockchainConfig {

	Web3j web3;
	Credentials credentials;

	private BlockchainConfig() {
	}

	private BlockchainConfig(String url, String keystorefile, String passcode) {
		this.web3 = Web3j.build(new HttpService(url)); // defaults to http://localhost:8545/
		Web3ClientVersion web3ClientVersion;
		try {
			web3ClientVersion = web3.web3ClientVersion().send();
		} catch (IOException e) {
			throw (new RuntimeException(e));
		}
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		System.out.println(clientVersion);

		try {
			System.out.println(web3.ethCoinbase().sendAsync().get().getAddress());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// send a transaction to a given address
		try {
			// final String keyfile =
			// "/Users/binod/Downloads/UTC--2018-08-14T03-03-16.633994578Z--b19aeb8b89c25d5cd038dfcf071297113a520546";
			// final String keyfile =
			// "/Users/binod/ethereum/localnetwork/keystore/UTC--2018-08-14T02-31-04.782982000Z--3980640925047be885b48ab4f63c53318059421d";
			this.credentials = WalletUtils.loadCredentials(passcode, keystorefile);
		} catch (Exception e) {
			throw (new RuntimeException(e));
		}
	}


	public static BlockchainConfig newConfig(String url, String keystorefile, String passcode) {
		return new BlockchainConfig(url, keystorefile, passcode);
	}
}
