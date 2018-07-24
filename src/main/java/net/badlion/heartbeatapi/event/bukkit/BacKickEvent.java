package net.badlion.heartbeatapi.event.bukkit;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * Is thrown when a player is kicked by Badlion AntiCheat (for auth errors or cheating).
 * Contains the UUID of the player. {@link BacKickEvent#getUniqueId()}
 *
 * Note : He is maybe not online anymore when this event is thrown.
 */
public class BacKickEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private final UUID uniqueId;

	public BacKickEvent(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	@SuppressWarnings("unused")
	public static HandlerList getHandlerList() {
		return BacKickEvent.handlers;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}

	@Override
	public HandlerList getHandlers() {
		return BacKickEvent.handlers;
	}
}
