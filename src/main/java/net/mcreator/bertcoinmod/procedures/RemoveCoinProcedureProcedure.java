package net.mcreator.bertcoinmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.bertcoinmod.network.BertCoinModModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class RemoveCoinProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins - DoubleArgumentType.getDouble(arguments, "amount");
			entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Coins = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Removed " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "amount")) + " coins to " + entity.getDisplayName().getString())), false);
	}
}
