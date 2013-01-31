package com.sk89q.craftbook.blockbag;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bags.BlockBagException;
import com.sk89q.worldedit.blocks.BaseBlock;

import java.util.HashMap;

public abstract class BlockBag implements Comparable {

    protected final Vector pos;
    protected HashMap<BaseBlock, Integer> contents;

    public BlockBag(Vector pos) {

        this.pos = pos;
        contents = new HashMap<BaseBlock, Integer>();
    }

    public abstract int count(BaseBlock block);

    /**
     * Add or remove a block from the BlockBag
     *
     * @param block    - The block
     * @param quantity - The amount of the block (negative for removal)
     *
     * @return - The amount of blocks successfully added
     */
    public abstract int add(BaseBlock block, int quantity) throws BlockBagException;

    /**
     * This method should be called after any transaction
     */
    public abstract void update();
}