package net.badlion.heartbeatapi.event.velocity;

import java.util.UUID;

/**
 * Is thrown when a player is banned by Badlion AntiCheat.
 * Contains the UUID of the player. {@link BacBanEvent#getUniqueId()}
 *
 * Note : He is maybe not online when this event is thrown.
 */
public class BacBanEvent {
	private final UUID uniqueId;

	public BacBanEvent(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}
}
