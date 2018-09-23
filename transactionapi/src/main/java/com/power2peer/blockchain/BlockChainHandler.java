package com.power2peer.blockchain;

public interface BlockChainHandler {

	public String getEthCoinbase();

	static class DefaultHandler implements BlockChainHandler {

		@Override
		public String getEthCoinbase() {
			return "0x9181918";
		}

		@Override
		public TransactionResult transfer(String ethAddress, String ethAddress2, int units) {
			return new TransactionResult();
		}

	}

	public static BlockChainHandler newDefaultHandler() {
		return new DefaultHandler();
	}

	public TransactionResult transfer(String ethAddress, String ethAddress2, int units);

}
