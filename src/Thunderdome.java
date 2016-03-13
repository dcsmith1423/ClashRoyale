
public class Thunderdome {
	
	public static void main(String[] args) {
		// GENEREATE THE 2 UNITS FOR THE FIGHT
//		double battleTime = 0;
		int battleTime = 0;
//		double totalTime = battleTime/10;
		
		ClashUnit [] card = new ClashUnit[2];
		
		card[0] = new ClashUnit();
		card[1] = new ClashUnit();
		
		card[0].name = "Giant Skeleton";
		card[0].attackDmg = 100;
		card[0].attackSpeed = 15;
		card[0].unitHealth = 2000;

		card[1].name = "PEKKA";
		card[1].attackDmg = 450;
		card[1].attackSpeed = 18;
		card[1].unitHealth = 2610;
		
		//MAIN LOOP IS HERE, THIS IS WHERE THE FIGHT HAPPENS
		while(card[0].isAlive && card[1].isAlive) {
			
			if (card[0].inCombat) {
				card[1].unitHealth -= card[0].attackDmg;
				card[0].inCombat = false;
			}
			
			if (card[1].inCombat) {
				card[0].unitHealth -= card[1].attackDmg;
				card[1].inCombat = false;
			}
			
			
			if (card[0].unitHealth <= 0 || card[1].unitHealth <= 0 ) {
				if (card[0].unitHealth <= 0 && card[1].unitHealth <= 0) {
					card[0].wins++;
					card[1].wins++;
					card[1].isAlive = false;
					card[0].isAlive = false;
				} else {
					if (card[0].unitHealth > 0) {
						card[0].wins++;
						System.out.println(card[0].name + " wins!");
						System.out.println(" with " + card[0].unitHealth + " HP remaining.");
						System.out.println("Battle Time = " + battleTime);
						card[1].isAlive = false;
					} else {
						card[0].isAlive = false;
						card[1].wins++;
						System.out.println(card[1].name + " wins!");
						System.out.println("with " + card[1].unitHealth + " HP remaining.");
						System.out.println("Battle Time = " + battleTime);
						card[0].isAlive = false;
					}
				}
			}
			
			/* Statement to declare time passage and re-initiate combat.
			 * I ran into floating point errors when this was a double so I made it an int.
			 * As such, "1" battleTime would be 0.1 seconds of game time.  
			 * TO DO- adjust the printout of battle time to accurately display to the tenth of a second
			 * ...need to learn how to convert an into to a double for this purpose, int/10 just gives an int, no decimal
			 */
		
			
			if (battleTime % card[0].attackSpeed == 0 || battleTime == 0 ) {
				card[0].inCombat = true;
			}
			
			if (battleTime % card[1].attackSpeed == 0 || battleTime == 0) {
				card[1].inCombat = true;
			}
			
			battleTime += 1;
		
		}
		
	}

}
