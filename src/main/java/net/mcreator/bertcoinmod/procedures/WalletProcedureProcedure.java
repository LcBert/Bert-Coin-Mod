package net.mcreator.bertcoinmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.bertcoinmod.network.BertCoinModModVariables;
import net.mcreator.bertcoinmod.init.BertCoinModModItems;

import java.util.concurrent.atomic.AtomicReference;

public class WalletProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double coins_count = 0;
		if (!entity.isShiftKeyDown()) {
			coins_count = 0;
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (BertCoinModModItems.COIN.get() == itemstackiterator.getItem()) {
							coins_count = coins_count + itemstackiterator.getCount();
						}
					}
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(BertCoinModModItems.COIN.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) coins_count, _player.inventoryMenu.getCraftSlots());
			}
			{
				double _setval = (entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins + coins_count;
				entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Coins = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if ((entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins < 64) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BertCoinModModItems.COIN.get()).copy();
					_setstack.setCount((int) (entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					double _setval = 0;
					entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Coins = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(BertCoinModModItems.COIN.get()).copy();
					_setstack.setCount(64);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					double _setval = (entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BertCoinModModVariables.PlayerVariables())).Coins - 64;
					entity.getCapability(BertCoinModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Coins = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
