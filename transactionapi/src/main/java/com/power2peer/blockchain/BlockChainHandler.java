package com.power2peer.blockchain;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public interface BlockChainHandler {

	public String getEthCoinbase();

	static class DefaultHandler implements BlockChainHandler {

		static File walletFile = new File("/tmp/tempWallet");

		private BlockchainConfig config;

		private static String walletFileName;

		public DefaultHandler() {
			try {
				if (walletFileName == null) {
					walletFileName = WalletUtils.generateFullNewWalletFile("12345678", walletFile);
				}
			} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException
					| CipherException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			config = BlockchainConfig.newConfig("http://localhost:7545",
					new File(walletFile, walletFileName).getAbsolutePath(), "");
		}

		@Override
		public String getEthCoinbase() {
			return "0x9181918";
		}

		@Override
		public TransactionReceipt transfer(String ethAddress, String ethAddress2, int units) {
			EtherTransfer transfer = new EtherTransfer(config);
			return transfer.transfer(ethAddress2, units);
		}

	}

	public static BlockChainHandler newDefaultHandler() {
		return new DefaultHandler();
	}

	public TransactionReceipt transfer(String ethAddress, String ethAddress2, int units);

}
