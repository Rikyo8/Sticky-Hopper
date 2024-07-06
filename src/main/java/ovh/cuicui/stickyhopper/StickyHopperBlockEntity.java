package ovh.cuicui.stickyhopper;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StickyHopperBlockEntity extends HopperBlockEntity implements Tickable {
    public StickyHopperBlockEntity(BlockPos pos, BlockState state) {
        super(Main.STICKY_HOPPER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void tick() {
        if (this.world != null && !this.world.isClient) {
            // Custom filtering logic for the sticky hopper
            for (int i = 0; i < this.size(); i++) {
                ItemStack stack = this.getStack(i);
                if (stack.isEmpty()) continue;

                // Example: Filter out all dirt blocks
                if (stack.getItem() == Main.DIRT_ITEM) {
                    this.setStack(i, ItemStack.EMPTY);
                }
            }

            // Ensure we call the original tick logic
            HopperBlockEntity.serverTick(this.world, this.pos, this);
        }
    }
}
