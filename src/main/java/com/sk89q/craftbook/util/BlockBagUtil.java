package com.sk89q.craftbook.util;

import com.google.common.collect.Lists;
import com.sk89q.craftbook.blockbag.BlockBag;
import com.sk89q.worldedit.bags.BlockBagException;
import com.sk89q.worldedit.blocks.BaseBlock;

import java.util.Collections;
import java.util.List;

public class BlockBagUtil {

    public static int countSum(BaseBlock block, BlockBag... blockBags) {

        int count = 0;
        for (BlockBag blockBag : blockBags) {
            count += blockBag.count(block);
        }
        return count;
    }

    /**
     * Add or remove blocks from a group of {@link BlockBag}
     *
     * @param block     - The block
     * @param amt       - The amt to add (negative for removal)
     * @param blockBags - The {@link BlockBag}(s)
     *
     * @return - The true number of blocks moved
     *
     * @throws BlockBagException
     */
    public static int add(BaseBlock block, int amt, BlockBag... blockBags) throws BlockBagException {

        boolean removal = false;
        if (amt < 0) removal = true;

        amt = Math.abs(amt);

        final int changeConst = amt;
        List<BlockBag> sortedList = Lists.newArrayList(blockBags);
        Collections.sort(sortedList);

        for (BlockBag blockBag : sortedList) {
            amt -= blockBag.add(block, removal ? amt * -1 : amt);
            blockBag.update();
            if (amt < 0) break;
        }
        return changeConst - amt;
    }
}
