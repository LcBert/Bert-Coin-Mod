package net.mcreator.bertcoinmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.bertcoinmod.network.BertCoinModModVariables;
import net.mcreator.bertcoinmod.init.BertCoinModModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class WalletTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == BertCoinModModItems.WALLET.get()) {
			tooltip.add(Component.literal(("Total Coins: " + new java.text.DecimalFormat("##").format((entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins))));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(""));
				tooltip.add(Component.literal("\u00A76Right-Click\u00A7r to insert"));
				tooltip.add(Component.literal("\u00A76Shift\u00A7r + \u00A76Right-Click\u00A7r to retrieve"));
			} else {
				tooltip.add(Component.literal("Press \u00A76Shift\u00A7r for more details"));
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("" + new java.text.DecimalFormat("##").format((entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins))), true);
	}
}
