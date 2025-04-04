package net.KyroXova.skyboundindustry.block;

import net.KyroXova.skyboundindustry.SkyBoundIndustry;
import net.KyroXova.skyboundindustry.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SkyBoundIndustry.MOD_ID);

    // Create New Block's Below!!

    public static final DeferredBlock<Block> ENDRONIUM_BLOCK = registerBlock("endronium_block",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> ENDRONIUM_ORE = registerBlock("endronium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour
                            .Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));


    // Keep New Block's Above these line ^_^

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
