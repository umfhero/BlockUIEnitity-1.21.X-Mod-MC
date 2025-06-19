package net.umf.blockmod.Item;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.umf.blockmod.BlockMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.umf.blockmod.block.ModBlocks;

import java.rmi.registry.Registry;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockMod.MODID);


    public static final RegistryObject<CreativeModeTab> BLOCK_ITEMS_TAB = CREATIVE_MODE_TABS.register("block_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_HARDWOOD.get()))
                    .title(Component.translatable("creative.blockmod.block_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_HARDWOOD.get());
                        output.accept(ModItems.HARDWOOD.get());
                        output.accept(ModBlocks.HARDWOOD_BLOCK.get());
                        output.accept(ModBlocks.RAWWOOD_BLOCK.get());
                        output.accept(ModBlocks.BIRCH_PLANKS.get());


                    }).build());

    public static final RegistryObject<CreativeModeTab> BLOCK_BLOCKS_TAB = CREATIVE_MODE_TABS.register("block_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BIRCH_PLANKS.get()))
                    .withTabsBefore(BLOCK_ITEMS_TAB.getId())
                    .title(Component.translatable("creative.blockmod.block_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.HARDWOOD_BLOCK.get());
                        output.accept(ModBlocks.RAWWOOD_BLOCK.get());
                        output.accept(ModBlocks.BIRCH_PLANKS.get());


                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
