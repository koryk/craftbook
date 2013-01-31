package com.sk89q.craftbook.blockbag;

import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import org.khelekore.prtree.PRTree;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockBagManager {

    // List of all Block Bags
    protected List<BlockBag> blockBags;
    // Band - BlockBags
    // protected HashMap<String, List<BlockBag>> bands;
    protected PRTree<BlockBag> blockBagTree;

    public BlockBagManager(LocalWorld world) {

        blockBags = new ArrayList<BlockBag>();
        // bands = new HashMap<String, List<BlockBag>>();
        // TODO Converter & Branch factor blockBagTree = new PRTree<BlockBag>();
    }

    public abstract List<BlockBag> getNearbyBlockBags(Vector pos);

    public List<BlockBag> getChannelBlockBags(String band) {

        throw new UnsupportedOperationException();
        //return Collections.unmodifiableList(bands.get(band));
    }

    public void createBlockBag(BlockBag blockBag) {

        createBlockBag(blockBag, null);
    }

    public void createBlockBag(BlockBag blockBag, String band) {

        /*
        if (band != null && !band.isEmpty()) {
            if (bands.containsKey(band)) {
                bands.get(band).add(blockBag);
            } else {
                bands.put(band, Lists.newArrayList(blockBag));
            }
        }
        */
        blockBags.add(blockBag);
        // TODO Converter & Branch factor blockBagTree = new PRTree<BlockBag>();
        blockBagTree.load(blockBags);
    }

    public void removeBlockBag(BlockBag blockBag) {

        blockBags.remove(blockBag);
        // TODO Converter & Branch factor blockBagTree = new PRTree<BlockBag>();
        blockBagTree.load(blockBags);
    }
}