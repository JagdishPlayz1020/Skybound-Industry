package net.KyroXova.skyboundindustry.item;

import net.KyroXova.skyboundindustry.SkyBoundIndustry;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SkyBoundIndustry.MOD_ID);

    // Create New Item's Below !!
    public static final DeferredItem<Item> ENDRONIUM =ITEMS.register("endronium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_ENDRONIUM =ITEMS.register("raw_endronium",
            () -> new Item(new Item.Properties()));


    // Keep New Item's Above these line ^_^

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
