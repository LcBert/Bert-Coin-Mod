
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bertcoinmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.bertcoinmod.item.WalletItem;
import net.mcreator.bertcoinmod.item.CoinItem;
import net.mcreator.bertcoinmod.BertCoinModMod;

public class BertCoinModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BertCoinModMod.MODID);
	public static final RegistryObject<Item> WALLET = REGISTRY.register("wallet", () -> new WalletItem());
	public static final RegistryObject<Item> COIN = REGISTRY.register("coin", () -> new CoinItem());
	// Start of user code block custom items
	// End of user code block custom items
}
