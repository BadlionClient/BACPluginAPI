package net.badlion.heartbeatapi;

import java.util.Collection;
import java.util.UUID;

public abstract class HeartbeatApi {
	static HeartbeatApi instance;

	/**
	 * Get the api instance
	 * Must be called after the Badlion Heartbeat plugin is initialized
	 *
	 * @return A singleton instance of the api
	 */
	public static HeartbeatApi getInstance() {
		return HeartbeatApi.instance;
	}

	/**
	 * Returns {@code true} if a player is using Badlion Anti-Cheat
	 *
	 * @param uuid UUID of player to check
	 * @return {@code true} if using Badlion Anti-Cheat
	 */
	public abstract boolean isPlayerUsingBadlionAnticheat(UUID uuid);

	/**
	 * Get if BAC-only mode is enabled
	 *
	 * @return {@code true} if BAC-only mode is enabled
	 */
	public abstract boolean isBacOnly();

	/**
	 * Enable or disable BAC-only mode (disabled by default)
	 * If enabled, player will need to use Badlion-Anticheat to log in the server
	 * Enabling this option while players are on will not kick them out of the network
	 * We recommend calling this method as quickly as you can in your plugin(s).
	 * This setting will be stored in the config to persist if the server restarts.
	 *
	 * @param enabled New state for the BAC-only mode
	 */
	public abstract void setBacOnly(boolean enabled);

	/**
	 * Add a player to the whitelist
	 * That player will be able to connect even if BAC-only mode is enabled and he is not using Badlion Anti-Cheat
	 * This whitelist will be stored in the config to persist if the server restarts.
	 *
	 * @param uuid UUID of player to add
	 */
	public abstract void addPlayerToWhitelist(UUID uuid);

	/**
	 * Remove a player from the whitelist
	 *
	 * @param uuid UUID of player to remove
	 */
	public abstract void removePlayerFromWhitelist(UUID uuid);

	/**
	 * Get the whitelisted players who can bypass the BAC-only mode
	 *
	 * @return Collection of uuids
	 */
	public abstract Collection<UUID> getWhitelistedPlayers();
}
