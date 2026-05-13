package com.hyper;

// import com.hyper.gui.ExampleGui;
import com.hyper.gui.ExampleScreen;
import net.fabricmc.api.ClientModInitializer;
import com.hyper.config.STBAConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class ShowTheBookAuthorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		System.out.println("Show The Book Author Mod is running!");

		AutoConfig.register(
				STBAConfig.class,
				GsonConfigSerializer::new
		);
	}
}