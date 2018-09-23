package com.power2peer.models;

import com.power2peer.blockchain.BlockChainHandler;
import com.power2peer.blockchain.TransactionResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class EnergyTransaction {

	@Getter
	private final RegisteredUser producer;

	@Getter
	private BlockChainHandler blockChainHandler;

	public EnergyTransaction(RegisteredUser producer) {
		this.producer = producer;
		this.blockChainHandler = BlockChainHandler.newDefaultHandler();
	}

	/**
	 * Sells units units of energy to consumer.
	 * 
	 * @param consumer
	 *            consumer to sell to
	 * @param units
	 *            Units of energy to sell
	 */
	public TransactionResult sellTo(RegisteredUser consumer, int units) {
		return blockChainHandler.transfer(producer.getEthAddress(), consumer.getEthAddress(), units);
	}

}
