package gregtech.api;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Made for static imports, this Class is just a Helper.
 */
public class GTValues {

    /**
     * <p/>
     * This is worth exactly one normal Item.
     * This Constant can be divided by many commonly used Numbers such as
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, ... 64 or 81
     * without loosing precision and is for that reason used as Unit of Amount.
     * But it is also small enough to be multiplied with larger Numbers.
     * <p/>
     * This is used to determine the amount of Material contained inside a prefixed Ore.
     * For example Nugget = M / 9 as it contains out of 1/9 of an Ingot.
     */
    public static final long M = 3628800;

    /**
     * Renamed from "FLUID_MATERIAL_UNIT" to just "L"
     * <p/>
     * Fluid per Material Unit (Prime Factors: 3 * 3 * 2 * 2 * 2 * 2)
     */
    public static final int L = 144;

    /**
     * The Item WildCard Tag. Even shorter than the "-1" of the past
     */
    public static final short W = OreDictionary.WILDCARD_VALUE;

    /**
     * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
     */
    public static final long[] V = new long[]{8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608, 33554432, 134217728, 536870912, Integer.MAX_VALUE};
    public static final int OldVLength = 10; // TODO Remove all uses of this

    public static final int ULV = 0;
    public static final int LV = 1;
    public static final int MV = 2;
    public static final int HV = 3;
    public static final int EV = 4;
    public static final int IV = 5;
    public static final int LuV = 6;
    public static final int ZPM = 7;
    public static final int UV = 8;

    public static final int UHV = 9;
    public static final int UEV = 10;
    public static final int UIV = 11;
    public static final int UMV = 12;
    public static final int UXV = 13;
    public static final int MAX = 14;

    /**
     * The short names for the voltages
     */
    public static final String[] VN = new String[] {"ULV", "LV", "MV", "HV", "EV", "IV", "LuV", "ZPM", "UV", "UHV", "UEV", "UIV", "UMV", "UXV", "MAX"};

    /**
     * Color values for the voltages
     */
    public static final int[] VC = new int[] {0xB4B4B4, 0xDCDCDC, 0xFF6400, 0xFFFF1E, 0x808080, 0xF0F0F5, 0xDCDCF5, 0xC8C8F5, 0xB4B4F5, 0xA0A0F5, 0x8C8CF5, 0x7878F5, 0x6464F5, 0x5050F5, 0x2828F5};

    /**
     * The long names for the voltages
     */
    public static final String[] VOLTAGE_NAMES = new String[] {"Ultra Low Voltage", "Low Voltage", "Medium Voltage", "High Voltage", "Extreme Voltage", "Insane Voltage", "Ludicrous Voltage", "ZPM Voltage", "Ultimate Voltage",
            "Highly Ultimate Voltage", "Extremely Ultimate Voltage", "Insanely Ultimate Voltage", "Mega Ultimate Voltage", "Extended Mega Ultimate Voltage", "Maximum Voltage"};

    /**
     * ModID strings, since they are quite common parameters
     */
    public static final String MODID = "gregtech",
        MODID_FR = "forestry",
        MODID_CT = "crafttweaker",
        MODID_TOP = "theoneprobe",
        MODID_CTM = "ctm",
        MODID_CC = "cubicchunks",
        MODID_AR = "advancedrocketry";

    //because forge is too fucking retarded to cache results or at least do not create fucking
    //immutable collections every time you retrieve indexed mod list
    private static final ConcurrentMap<String, Boolean> isModLoadedCache = new ConcurrentHashMap<>();

    public static boolean isModLoaded(String modid) {
        if (isModLoadedCache.containsKey(modid)) {
            return isModLoadedCache.get(modid);
        }
        boolean isLoaded = Loader.instance().getIndexedModList().containsKey(modid);
        isModLoadedCache.put(modid, isLoaded);
        return isLoaded;
    }

}
