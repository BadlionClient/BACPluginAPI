# Badlion AntiCheat API

This repository explains how to use Badlion AntiCheat Api bundled in the BAC plugin.

You can purchase it at [https://store.badlion.net/category/bac/](https://store.badlion.net/category/bac/)

#### Maven dependency

1. Clone this repository
2. Run `mvn clean install`
3. Add the following code to your pom.xml file :
```xml
<dependency>
    <groupId>net.badlion.heartbeat</groupId>
    <artifactId>heartbeat-api</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

*/!\ Make sure to set it as provided or it won't be working properly.*

### API Usage

All the methods that you can use are documented [here](https://github.com/BadlionNetwork/BACPluginAPI/blob/master/src/main/java/net/badlion/heartbeatapi/HeartbeatApi.java).

### Plugin Message API

In case you are running the plugin on your BungeeCord proxy, and you want to know if an user is using Badlion Anticheat from your Bukkit server, you can use our plugin message API

```java
public class BadlionAnticheatExample extends JavaPlugin implements Listener, PluginMessageListener {

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onLogin(final PlayerJoinEvent event) {
        this.getServer().getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

                try {
                    dataOutputStream.writeUTF("heartbeat");
                } catch (IOException ignored) {
                    return;
                }

                event.getPlayer().sendPluginMessage(BadlionAnticheatExample.this, "BungeeCord", byteArrayOutputStream.toByteArray());
            }
        }, 20L);
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (channel.equals("BungeeCord")) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bytes));

            try {
                if (dataInputStream.readUTF().equals("heartbeat")) {
                    switch (dataInputStream.readUTF()) {
                        case "true":
                            // Your code here
                            // User is using Badlion AntiCheat
                            break;

                        case "false":
                            // Your code here
                            // User is not using Badlion AntiCheat
                            break;
                    }
                }
            } catch (IOException ignored) {

            }
        }
    }
}

```

