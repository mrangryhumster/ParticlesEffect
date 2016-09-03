package org.archcraft;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;


public class ParticlesEffectProcessor implements Runnable {

    private int m_internal_counter = 0;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            m_internal_counter++;
            //Check armor set
            /*
            if (player.getEquipment().getHelmet().hasItemMeta() &&
                    player.getEquipment().getChestplate().hasItemMeta() &&
                    player.getEquipment().getLeggings().hasItemMeta() &&e
                    player.getEquipment().getBoots().hasItemMeta()) {

            }
            */

            //Check weapon
            if (player.getEquipment().getItemInMainHand().hasItemMeta() &&
                    player.getEquipment().getItemInMainHand().getItemMeta().hasLore()) {
                //effects list
                for (String str : player.getEquipment().getItemInMainHand().getItemMeta().getLore()) {
                    switch (str) {
                        //White orb effect
                        case "§7[§8WhiteOrb§7]": {
                            Location location = player.getLocation();
                            location.add(Math.sin(Math.PI * (((double) System.currentTimeMillis()) / 1000.0)),
                                    (Math.sin(Math.PI * (((double) System.currentTimeMillis()) / 750.0)) / 2.0) + 1.0,
                                    Math.cos(Math.PI * (((double) System.currentTimeMillis()) / 1000.0)));
                            player.getWorld().spawnParticle(Particle.END_ROD, location, 1, 0, 0, 0, 0);
                        }
                        break;

                        //Winter effect
                        case "§7[§8Winter§7]": {
                            MaterialData data = new MaterialData(Material.SNOW);
                            Location location = player.getLocation();
                            location.add(0, 3, 0);
                            player.getWorld().spawnParticle(Particle.FALLING_DUST, location, 1, .75, .5, .75, 0, data);
                        }
                        break;

                        //Aura effect
                        case "§7[§8Aura§7]": {
                            double time = ((double) System.currentTimeMillis());
                            double amp = Math.sin(Math.PI * (time/4000.0)) + 2.0;
                            for (double rp = 0; rp < (Math.PI * 2); rp += (Math.PI / 8.0)) {
                                double x = Math.sin(rp + (time/2500.0)) * amp;
                                double z = Math.cos(rp + (time/2500.0)) * amp;
                                Location location = player.getLocation();
                                location.add(x,0.1,z);
                                player.getWorld().spawnParticle(Particle.CRIT_MAGIC, location, 1, 0, 0, 0, 0);
                            }
                        }
                        break;

                        //Debug effect
                        case "§7[§8Nether§7]": {
                            Location location = player.getLocation();
                            location.add(0, 0.5, 0);
                            player.getWorld().spawnParticle(Particle.PORTAL, location, 2, .25, .5, .25, 0.1);
                        }
                        break;

                        //Debug effect
                        case "§7[§8Enchant§7]": {
                            Location location = player.getLocation();
                            location.add(0, 0.5, 0);
                            player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, location, 1, .75, .5, .75, 0);
                        }
                        break;

                    }
                }
            }
        }
    }
}

