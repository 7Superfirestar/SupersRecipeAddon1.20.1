package net.sevensuper.supersrecipemod;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "supersrecipemod")
public class RecipeLogger {

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();
        RegistryAccess registryAccess = server.registryAccess();
        RecipeManager recipeManager = server.getRecipeManager();

        for (Recipe<?> recipe : recipeManager.getRecipes()) {
            ResourceLocation id = recipe.getId();
            if ("supersrecipemod".equals(id.getNamespace())) {
                System.out.println("Loaded recipe: " + id.toString());
                System.out.println("Type: " + recipe.getType().toString());
                System.out.println("Output: " + recipe.getResultItem(registryAccess).getItem());
            }
        }
    }
}
