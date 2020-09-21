package net.badlion.heartbeatapi.event.velocity;

import java.util.UUID;

/**
 * Is thrown when a player is kicked by Badlion AntiCheat (for auth errors or cheating).
 * Contains the UUID of the player. {@link BacKickEvent#getUniqueId()}
 *
 * Note : He is maybe not online anymore when this event is thrown.
 */
public class BacKickEvent {
	private final UUID uniqueId;

	public BacKickEvent(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}
}
