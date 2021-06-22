package ovh.cuicui.stickyhopper;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class StickyHopperBlockEntity extends HopperBlockEntity {
    public StickyHopperBlockEntity(BlockPos pos, BlockState state) { super(pos, state); }

    @Override
    protected Text getContainerName() { return new TranslatableText(Main.STICKY_HOPPER_CONTAINER_ID); }

    @Override
    public BlockEntityType<?> getType() { return Main.STICKY_HOPPER_BLOCK_ENTITY; }
}
