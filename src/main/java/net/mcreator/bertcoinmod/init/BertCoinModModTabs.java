
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bertcoinmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.bertcoinmod.BertCoinModMod;

public class BertCoinModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BertCoinModMod.MODID);
	public static final RegistryObject<CreativeModeTab> COIN_MOD_TAB = REGISTRY.register("coin_mod_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.bert_coin_mod.coin_mod_tab")).icon(() -> new ItemStack(BertCoinModModItems.WALLET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BertCoinModModItems.WALLET.get());
				tabData.accept(BertCoinModModItems.COIN.get());
			})

					.build());
}
