package net.badlion.heartbeatapi.event.bukkit;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * Is thrown when a player is banned by Badlion AntiCheat.
 * Contains the UUID of the player. {@link BacBanEvent#getUniqueId()}
 *
 * Note : He is maybe not online when this event is thrown.
 */
public class BacBanEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private final UUID uniqueId;

	public BacBanEvent(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	@SuppressWarnings("unused")
	public static HandlerList getHandlerList() {
		return BacBanEvent.handlers;
	}

	public UUID getUniqueId() {
		return this.uniqueId;
	}

	@Override
	public HandlerList getHandlers() {
		return BacBanEvent.handlers;
	}
}
