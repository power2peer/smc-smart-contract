import java.math.BigDecimal;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class EtherTransfer {

	private final BlockchainConfig config;

	public EtherTransfer(BlockchainConfig config) {
		this.config = config;
	}

	public boolean transfer(String toAddress) {

		TransactionReceipt transactionReceipt;
		try {
			transactionReceipt = Transfer
					.sendFunds(config.web3, config.credentials, toAddress, BigDecimal.valueOf(5.0), Convert.Unit.ETHER)
					.send();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(transactionReceipt.toString());

		return true;
	}
}
