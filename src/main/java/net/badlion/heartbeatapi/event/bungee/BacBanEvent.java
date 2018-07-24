package net.badlion.heartbeatapi.event.bungee;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.event.AsyncEvent;

import java.util.UUID;

/**
 * Is thrown when a player is banned by Badlion AntiCheat.
 * Contains the UUID of the player. {@link BacBanEvent#getUniqueId()}
 *
 * Note : He is maybe not online when this event is thrown.
 */
public class BacBanEvent extends AsyncEvent<BacBanEvent> {

	private final UUID uniqueId;

	public BacBanEvent(Callback<BacBanEvent> done, UUID uniqueId) {
		super(done);

		this.uniqueId = uniqueId;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}
}
