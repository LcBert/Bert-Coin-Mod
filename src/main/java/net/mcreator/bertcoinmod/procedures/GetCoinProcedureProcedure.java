package net.mcreator.bertcoinmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.bertcoinmod.network.BertCoinModModVariables;

public class GetCoinProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double coins_count = 0;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " has "
					+ new java.text.DecimalFormat("##").format((entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins) + " coins")), false);
	}
}
