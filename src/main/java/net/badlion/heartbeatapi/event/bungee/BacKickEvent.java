package net.badlion.heartbeatapi.event.bungee;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.event.AsyncEvent;

import java.util.UUID;

/**
 * Is thrown when a player is kicked by Badlion AntiCheat (for auth errors or cheating).
 * Contains the UUID of the player. {@link BacKickEvent#getUniqueId()}
 *
 * Note : He is maybe not online anymore when this event is thrown.
 */
public class BacKickEvent extends AsyncEvent<BacKickEvent> {
	private final UUID uniqueId;

	public BacKickEvent(Callback<BacKickEvent> done, UUID uniqueId) {
		super(done);

		this.uniqueId = uniqueId;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}
}
