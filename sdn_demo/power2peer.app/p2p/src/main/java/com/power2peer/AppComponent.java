/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.power2peer;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Skeletal ONOS application component.
 */
@Component(immediate = true)
public class AppComponent {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Activate
	protected void activate() {
		log.info("Started");
		String url = "https://Power2Peer.com/t/";
		String keystorefile = "/tmp/UTC--2018-08-14T03-03-16.633994578Z--b19aeb8b89c25d5cd038dfcf071297113a520546";
		BlockchainConfig config = BlockchainConfig.newConfig(url, keystorefile, "12341234");
		EtherTransfer transfer = new EtherTransfer(config);
		transfer.transfer("0x3980640925047be885b48ab4f63c53318059421d");
	}

	@Deactivate
	protected void deactivate() {
		log.info("Stopped");
	}

}
