/*Final Project Java
Code Made By Rayhan Ali Darmawan - 2301891683
Monster Slayer RPG*/

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Integer> hp = new ArrayList<Integer>();
	ArrayList<Integer> dmg = new ArrayList<Integer>();
	ArrayList<Integer> res = new ArrayList<Integer>();
	int action, mana, hppot = 5, manapot = 5,  status1 = 50, status2 = 20, status3 = 20, level = 1,  dice;
	String name = "Hero1";

	public Main() {
		int start = 0;

//=========================================================================================================================================//	
//Main Menu
		
		do {
			welcome();
			start = scan.nextInt();
			scan.nextLine();
		} while (start != 1);

//=========================================================================================================================================//
//Character Builder
		
		do {
			System.out.println();
			System.out.println("Enter your character name! [5 - 15 Characters]");
			System.out.print(">> ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 15);

//=========================================================================================================================================//
//Character Status Initialization
		
		hp.add(status1);
		dmg.add(status2);
		res.add(status3);
		mana = 100;

//=========================================================================================================================================//
//Game Intro
		
		intro();
		int intro = 0;
		do {
			System.out.println("Press '1' to continue!");
			System.out.print(">> ");
			intro = scan.nextInt();
			scan.nextLine();
		} while (intro != 1);
		
//=========================================================================================================================================//	
//Monster Initialization
		
		slime slime = new slime();
		slime.status();
		
		goblin goblin1 = new goblin();
		goblin1.status();
		
		goblin goblin2 = new goblin();
		goblin2.status();
		
		orc orc1 = new orc();
		orc1.status();
		
		minotaur tauren = new minotaur();
		tauren.status();
		
		orc orc2 = new orc();
		orc2.status();
		
		kobold kobold1 = new kobold();
		kobold1.status();
		
		kobold kobold2 = new kobold();
		kobold2.status();
		
		ogre ogre = new ogre();
		ogre.status();
		
		dragon dragonboss = new dragon();
		dragonboss.status();
		
//=========================================================================================================================================//	
//Game Level
//Karena pakai interface dan bukan abstract bagian gambar monster error apabila level saya jadikan metoda, maka dari itu saya
//buat level game secara manual mengingat dibutuhkan interface dan jumlah level yang sedikit (10).
		
		System.out.println();
		System.out.println("You've encountered Slime level 1");
		do {
			slime.pic();
			System.out.println();
			yourstat();
			System.out.println();
			
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(1, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			System.out.println();
			
			rolldice();
			if(dice <= 25) {
				slime.skill(level);
			}else {
				mobattack(level);
				System.out.println("You took " + dmg.get(1) + " dmg");
			}
			
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(1) > 0);
		
		level = level + 1;
		status1 = status1 + 10;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Goblin level 2");
		
		do {
			goblin1.pic();
			System.out.println("Level 2 Goblin");
			System.out.println("HP = " + hp.get(2));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(2, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
				mobattack(level);
				System.out.println("You took " + dmg.get(2) + " dmg");
				goblin1.skill(level);
				System.out.println();
				endgame();
		} while (hp.get(0) > 0 && hp.get(2) > 0);
		
		level = level + 1;
		status1 = status1 + 10;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Goblin level 3");
		
		do {
			goblin2.pic();
			System.out.println("Level 3 Goblin");
			System.out.println("HP = " + hp.get(3));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(3, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			mobattack(level);
			System.out.println("You took " + dmg.get(3) + " dmg");
			goblin2.skill(level);
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(3) > 0);
		
		level = level + 1;
		status1 = status1 + 10;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Orc level 4");
		
		do {
			orc1.pic();
			System.out.println("Level 4 Ogre");
			System.out.println("HP = " + hp.get(4));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(4, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			rolldice();
			if(dice <= 25) {
				orc1.skill(level);
			}else {
				mobattack(level);
				System.out.println("You took " + dmg.get(4) + " dmg");
			}
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(4) > 0);
		
		level = level + 1;
		status1 = status1 + 15;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("The ground shook.");
		System.out.println();
		System.out.println("Taurdon arrived.");
		
		do {
			tauren.pic();
			System.out.println("Level 5 Tauren Boss");
			System.out.println("HP = " + hp.get(5));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(5, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			rolldice();
			if(dice <= 20) {
				tauren.skill1(level);
			}else if(dice > 20 && dice <= 40) {
				tauren.skill2(level);
			}else {
			
				mobattack(level);
				System.out.println("You took " + dmg.get(5) + " dmg");
			}
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(5) > 0);
		
		level = level + 1;
		status1 = status1 + 15;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Orc level 6");
		
		do {
			orc2.pic();
			System.out.println("Level 6 Orc");
			System.out.println("HP = " + hp.get(6));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(6, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			rolldice();
			if(dice <= 25) {
				orc2.skill(level);
			}else {
				mobattack(level);
				System.out.println("You took " + dmg.get(6) + " dmg");
			}
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(6) > 0);
		
		level = level + 1;
		status1 = status1 + 15;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Kobold level 7");
		
		do {
			kobold1.pic();
			System.out.println("Level 7 Kobold");
			System.out.println("HP = " + hp.get(7));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(7, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			mobattack(level);
			System.out.println("You took " + dmg.get(7) + " dmg");
			kobold1.skill(level);
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(7) > 0);
		
		level = level + 1;
		status1 = status1 + 20;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Kobold level 8");
		
		do {
			kobold2.pic();
			System.out.println("Level 8 Kobold");
			System.out.println("HP = " + hp.get(8));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(8, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			mobattack(level);
			System.out.println("You took " + dmg.get(8) + " dmg");
			kobold2.skill(level);
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(8) > 0);
		
		level = level + 1;
		status1 = status1 + 20;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("You've encountered Ogre level 9");
		
		do {
			ogre.pic();
			System.out.println("Level 9 Ogre");
			System.out.println("HP = " + hp.get(9));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(9, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
		
				mobattack(level);
				System.out.println("You took " + dmg.get(1) + " dmg");
				ogre.skill(level);
				System.out.println();
				endgame();
		} while (hp.get(0) > 0 && hp.get(9) > 0);
		
		level = level + 1;
		status1 = status1 + 20;
		setstatus(status1, status2, status3);
		
		System.out.println();
		System.out.println("The temperature rises.");
		System.out.println("The land is covered in ash.");
		System.out.println();
		System.out.println("Alakagon is here.");
		
		do {
			dragonboss.pic();
			System.out.println("Level 10 Alakagon");
			System.out.println("HP = " + hp.get(10));
			System.out.println();
			yourstat();
			System.out.println();
			actionmenu();
			action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
			case 1:
				attack(10, 0);
				break;
			case 2:
				charskill();
				break;
			case 3:
				item();
				break;
			default:
				break;
			}
			
			rolldice();
			if(dice <= 30) {
				dragonboss.skill2(level);
			}else {
			
				mobattack(level);
				System.out.println("You took " + dmg.get(1) + " dmg");
			}
			dragonboss.skill1(level);
			System.out.println();
			endgame();
		} while (hp.get(0) > 0 && hp.get(10) > 0);
		

		
//=========================================================================================================================================//
		
	}
	
	private void charskill() {
		// TODO Auto-generated method stub
		int option;
		charskillset cs = new charskillset();
		
		if(mana >= 25) {
			
		
		do {
			
			System.out.println();
			System.out.println("Skills: ");
			if(level >= 2) {
				System.out.println("1. Heavy Swing [25 MC] (2x dmg)");
			}
			
			if(level >= 5) {
				System.out.println("2. Corrosive Armor [40 MC] (-50% enemy res)");
			}
			
			if(level >= 7) {
				System.out.println("3. Berserk [50 MC] (HP +100%, ATK +50%, RES -50%)");
			}
			System.out.println(">> ");
			
			option = scan.nextInt();
			scan.nextLine();
			
			if(level >= 2) {
				switch (option) {
				case 1:
					cs.hs(level);
					break;
				}
			}else if(level >= 5) {
				switch (option) {
				case 1:
					cs.hs(level);
					break;
				case 2:
					cs.ca(level);
					break;
				}
			}else if(level >= 7) {
				switch (option) {
				case 1:
					cs.hs(level);
					break;
				case 2:
					cs.ca(level);
					break;
				case 3:
					cs.ber();
					break;
				}
			}
			
		} while (option < 1 && option > 3);
		}else {
			System.out.println("Not enough mana to use any skill (minimum 25).");
		}
	}

	private void rolldice() {
		// TODO Auto-generated method stub
		dice = (int)(Math.random()*100);
	}

	private void mobattack(int a) {
		// TODO Auto-generated method stub
		int hpchar = hp.get(0);;
		int charres = res.get(0);
		hpchar = hpchar - (dmg.get(a) * (1 - (charres/100)));
		
		hp.set(0, hpchar);
	}

	private void item() {
		// TODO Auto-generated method stub
		int choose = 0;
		System.out.println();
		System.out.println("Item : ");
		System.out.println("1. HP Potion = " + hppot);
		System.out.println("2. Mana Potion = " + manapot);
		System.out.print(">> ");
		
		do {
			choose = scan.nextInt();
			switch (choose) {
			case 1:
				if(hp.get(0) + 100 > status1) {
					hp.set(0, status1);
				}else {
					hp.set(0, hp.get(0) + 100);
				}
				hppot = hppot - 1;
				break;
			case 2:
				mana = 100;
				manapot = manapot - 1;
				break;
			}
		} while (choose < 1 && choose > 2);
	}

	private void endgame() {
		if(hp.get(0) <= 0) {
			System.out.println();
			System.out.println("You Died. Better luck next time!");
			System.out.println("Score = " + (level*100));
			System.exit(0);
		}
	}
	
	private void yourstat() {
		// TODO Auto-generated method stub
		System.out.println(name + "'s HP   = " + hp.get(0));
		System.out.println(name + "'s MANA = " + mana);
	}

	private void actionmenu() {
		// TODO Auto-generated method stub
		System.out.println("Choose an action!");
		System.out.println("1. Attack");
		System.out.println("2. Skill");
		System.out.println("3. Item");
		System.out.print(">> ");
	}

	private void setstatus(int a, int b, int c) {
		// TODO Auto-generated method stub

		switch (level) {
		case 1:
			break;
		case 2:
			c = c + 10;
			hppot = hppot + 1;
			manapot = manapot + 1;
			System.out.println();
			System.out.println("You are now at level 2, unlocked skill 'Heavy Swing'");
			System.out.println("You've got 1 HP potion and 1 mana potion");
			System.out.println("You've got bronze armor, res up by 10!");
			status3 = c;
			break;
		case 3:
			b = b + 10;
			System.out.println();
			System.out.println("You've got bronze sword, atk up by 10!");
			status2 = b;
			break;
		case 4:
			c = c + 15;
			hppot = hppot + 2;
			manapot = manapot + 2;
			System.out.println();
			System.out.println("You've got 2 HP potion and 2 mana potion");
			System.out.println("You've got steel armor, res up by 15!");
			status3 = c;
			break;
		case 5:
			b = b + 20;
			System.out.println();
			System.out.println("You are now at level 5, unlocked skill 'Corrosive Armor'");
			System.out.println("You've got steel sword, atk up by 20!");
			status2 = b;
			break;
		case 6:
			c = c + 20;
			hppot = hppot + 3;
			manapot = manapot + 3;
			System.out.println();
			System.out.println("You've got 3 HP potion and 3 mana potion");
			System.out.println("You've got gold armor, res up by 20!");
			status3 = c;
			break;
		case 7:
			b = b + 30;
			System.out.println();
			System.out.println("You are now at level 7, unlocked skill 'Berserker'");
			System.out.println("You've got gold sword, atk up by 30!");
			status2 = b;
			break;
		case 8:
			c = 80;
			hppot = hppot + 4;
			manapot = manapot + 4;
			System.out.println();
			System.out.println("You've got 4 HP potion and 4 mana potion");
			System.out.println("You've got diamond armor, res reaches maximum!");
			status3 = c;
			break;
		case 9:
			b = 120;
			System.out.println();
			System.out.println("You've got diamond sword, atk reaches full potential!");
			status2 = b;
			break;
		case 10:
			break;
		
		default :
			break;
		}
		
		status2 = b;
		status3 = c;
		hp.set(0, a);
		dmg.set(0, b);
		res.set(0, c);
		mana = 100;
		
	}

	private void intro() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome to this RPG World : Monster Slayer!");
		System.out.println("The goal of this game is to beat monsters in every level and ultimately slay the dragon!");
		System.out.println("You are a warrior called " + name + " and this is the start of your journey.");

	}

	private void attack(int i, int j) {
		// TODO Auto-generated method stub
		int a = hp.get(i);
		int b =  res.get(i);
		int attacker = dmg.get(j);
		
		a = a - (attacker * (1-(b/100)));
		
		hp.set(i, a);
		
		System.out.println("You deal " + (attacker * (1-(b/100))) + " damage");
	}

	abstract class Boss{
		public abstract void status();
		public abstract void skill1(int a);
		public abstract void skill2(int a);
		public abstract void pic();
	}
	
	class minotaur extends Boss{

		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(180);
			dmg.add(25);
			res.add(5);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("       -\"\"\\\r\n" + 
					"    .-\"  .`)     (\r\n" + 
					"   j   .'_+     :[                )      .^--..\r\n" + 
					"  i    -\"       |l                ].    /      i\r\n" + 
					" ,\" .:j         `8o  _,,+.,.--,   d|   `:::;    b\r\n" + 
					" i  :'|          \"88p;.  (-.\"_\"-.oP        \\.   :\r\n" + 
					" ; .  (            >,%%%   f),):8\"          \\:'  i\r\n" + 
					"i  :: j          ,;%%%:; ; ; i:%%%.,        i.   `.\r\n" + 
					"i  `: ( ____  ,-::::::' ::j  [:```          [8:   )\r\n" + 
					"<  ..``'::::8888oooooo.  :(jj(,;,,,         [8::  <\r\n" + 
					"`. ``:.      oo.8888888888:;%%%8o.::.+888+o.:`:'  |\r\n" + 
					" `.   `        `o`88888888b`%%%%%88< Y888P\"\"'-    ;\r\n" + 
					"   \"`---`.       Y`888888888;;.,\"888b.\"\"\"..::::'-'\r\n" + 
					"          \"-....  b`8888888:::::.`8888._::-\"\r\n" + 
					"             `:::. `:::::O:::::::.`%%'|\r\n" + 
					"              `.      \"``::::::''    .'\r\n" + 
					"                `.                   <\r\n" + 
					"                  +:         `:   -';\r\n" + 
					"                   `:         : .::/\r\n" + 
					"                    ;+_  :::. :..;;;       LS\r\n" + 
					"                    ;;;;,;;;;;;;;,;;");
		}

		@Override
		public void skill1(int a) {
			// TODO Auto-generated method stub
			System.out.println();
			System.out.println("Taurdon used return damage!");
			System.out.println("Taurdon healed by " + dmg.get(0) + " and returned half of it.");
			int x = hp.get(level);
			int y = hp.get(0);
			x = x + dmg.get(0);
			y = (int) (y - dmg.get(0)*0.1);
			hp.set(0, y);
			hp.set(a, x);
		} /*Skill too op work in progress*/ 

		@Override
		public void skill2(int a) {
			// TODO Auto-generated method stub
			int x = hp.get(0);
			int y = res.get(0);
			
			x = x - (80 * (1 - (y/50)));
					
			System.out.println();
			System.out.println("Taudon used bullrush!");
			System.out.println("You took " + (50 * (1 - (y/50)) + " damage"));
			
			hp.set(0, x);
		}
		
	}
	
	class dragon extends Boss{

		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(375);
			dmg.add(100);
			res.add(66);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("                                ,- \r\n" + 
					"                               //        \r\n" + 
					"                              /:      ,\r\n" + 
					"                             ;.(     //\r\n" + 
					"                   |   ,     /`|    //\r\n" + 
					"                   |\\  |\\    |,|   //\r\n" + 
					"                |  (\\  (\\    |`|   |(\r\n" + 
					"                (\\  \\\\  \\\\   |,|   ;|\r\n" + 
					"            .   ||   \\\\  \\\\  |`(   ;( \r\n" + 
					"            \\\\   \\\\  \\\\  \\\\  |.\\\\  ((                              \r\n" + 
					"             \\\\   \\\\  \\\\  \\\\  \\\\ \\;/:\\                 \r\n" + 
					"               \\\\  \\\\  \\'. \\\\_,\\\\ /\\\"\"-._                \r\n" + 
					"                \\\\  \\\\  \\ \\-\"   \\/ `;._ \".\r\n" + 
					"               ___\\\\-\\\\-\" \\ \\_  /,  |_ \"._\\\r\n" + 
					"         _,--\"\"___ \\ \\,_   \"-_\"- |\".|(._ \".\".-.\r\n" + 
					"     _,-\"_,--\"\"\"__ ) \".\"-_    \"--\\ \\\"(\"o\\_\\ \"- \".\r\n" + 
					"   ,\",-\"\"\" _.-'''_-\"   \"-_\"-.__   \\ \\_\\_//\\)__\"\\_)\r\n" + 
					" ,\"    ',-'  ,-\"\"   7\"  _ \"-.._\"\"_>\\__`\"\"'\"__ \"\"``-._\r\n" + 
					"        ;  ,\" ,-\",'/` ,\":\\.    `   `  `\"\"\"___`\"\"-._  \".   )\r\n" + 
					"        ;,\"_,\" ,' /`,\"}}::\\\\         `... \\____''' \"\\  '.|\\\r\n" + 
					"       ,\",\"   :  /`/{{)/:::\"\\__,---._    \\  \\_____'''\\    \\\r\n" + 
					"      , ,\"_  ;  /`/ ///::::::::' ,-\"-\\    \\__   \\____''\\ \\ \\\r\n" + 
					"     ,,\"   `;| \";; /}}/::'``':::(._``.\"-.__  \"\"\"--    '_\\ \\ \\\r\n" + 
					"    ('       ;// / {;;:'`````':; /`._.\"\"\"  \"\"-.._ `\"-. \" (   )\r\n" + 
					"    /         )(/ <\";\"'``   ``/ /_.(             \"_  \"-_\"\\`);\r\n" + 
					"              (/ <\";\"``     `/ /`,(                \"._ _\".\\; \r\n" + 
					"               |<\";\"`   ``  / /\"-\"   ctr              \"  \r\n" + 
					"               <\";\"` ``    / /__,;   ");
		}

		@Override
		public void skill1(int a) {
			// TODO Auto-generated method stub
			int x = hp.get(0);
			int y = res.get(0);
			x = x - (30 * (1 - (y/100)));
			hp.set(0, x);
			System.out.println();
			System.out.println("It's cataclysm! You took damage every turn");
		}

		@Override
		public void skill2(int a) {
			// TODO Auto-generated method stub
			int x = hp.get(0);
			int y = res.get(0);
			x = x - 100;
			hp.set(0, x);
			
			System.out.println();
			System.out.println("Alakagon used fire breath!");
			System.out.println("You took 100 pure damage");
		}
		
	}

	class slime implements Monster{
		

		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(30);
			dmg.add(10);
			res.add(0);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("          ██████████          \r\n" + 
					"      ████░░░░░░░░░░████      \r\n" + 
					"    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    \r\n" + 
					"  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  \r\n" + 
					"  ██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██  \r\n" + 
					"██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██\r\n" + 
					"██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██\r\n" + 
					"██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██\r\n" + 
					"██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒██\r\n" + 
					"██▓▓▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▓▓██\r\n" + 
					"  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██  \r\n" + 
					"    ██████████████████████    \r\n" + 
					"");
			System.out.println("Level 1 Slime");
			System.out.println("HP = " + hp.get(1));
		}

		@Override
		public void skill(int a) {
			// TODO Auto-generated method stub
			int x = hp.get(a);
			x = x + 10;
			hp.set(a, x);
			System.out.println();
			System.out.println("Slime used recover!");
			System.out.println("HP up by 10");
		}
	}
	
	class goblin implements Monster{

		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(80);
			dmg.add(15);
			res.add(10);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("            -._ `. `-.`-. `-.\r\n" + 
					"             _._ `-._`.   .--.  `.\r\n" + 
					"          .-'   '-.  `-|\\/    \\|   `-.\r\n" + 
					"        .'         '-._\\   (o)O) `-.\r\n" + 
					"       /         /         _.--.\\ '. `-. `-.\r\n" + 
					"      /|    (    |  /  -. ( -._( -._ '. '.\r\n" + 
					"     /  \\    \\-.__\\ \\_.-'`.`.__'.   `-, '. .'\r\n" + 
					"     |  /\\    |  / \\ \\     `--')/  .-'.'.'\r\n" + 
					" .._/  /  /  /  / / \\ \\          .' . .' .'\r\n" + 
					"/  ___/  |  /   \\ \\  \\ \\__       '.'. . .\r\n" + 
					"\\  \\___  \\ (     \\ \\  `._ `.     .' . ' .'\r\n" + 
					" \\ `-._\\ (  `-.__ | \\    )//   .'  .' .-'\r\n" + 
					"  \\_-._\\  \\  `-._\\)//    \"\"_.-' .-' .' .'\r\n" + 
					"    `-'    \\ -._\\ \"\"_..--''  .-' .'\r\n" + 
					"            \\/    .' .-'.-'  .-' .-'\r\n" + 
					"                .-'.' .'  .' .-'");
		}

		@Override
		public void skill(int a) {
			// TODO Auto-generated method stub
			System.out.println();
			System.out.println("Goblin's sword have poison applied!");
			System.out.println("You took 5 damage every turn!");
			int x = hp.get(0);
			x = x - 5;
			hp.set(0, x);
		}
	}
	
		class orc implements Monster{
			
			
			@Override
			public void skill(int a) {
				// TODO Auto-generated method stub
				res.set(a, 80);	
				System.out.println("Orc used iron skin, res is set to 80");
			}

			@Override
			public void status() {
				// TODO Auto-generated method stub
				hp.add(100);
				dmg.add(25);
				res.add(40);
			}

			@Override
			public void pic() {
				// TODO Auto-generated method stub
				System.out.println("                           __.--|~|--.__                     ,,;/;\r\n" + 
						"                         /~     | |    ;~\\                		 ,;;;/;;'\r\n" + 
						"                        /|      | |    ;~\\\\                     ,;;;;/;;;'\r\n" + 
						"                       |/|      \\_/   ;;;|\\                    ,;;;;/;;;;'\r\n" + 
						"                       |/ \\          ;;;/  )                 ,;;;;/;;;;;'\r\n" + 
						"                   ___ | ______     ;_____ |___....__      ,;;;;/;;;;;'\r\n" + 
						"             ___.-~ \\\\(| \\  \\.\\ \\__/ /./ /:|)~   ~   \\   ,;;;;/;;;;;'\r\n" + 
						"         /~~~    ~\\    |  ~-.     |   .-~: |//  _.-~~--,;;;;/;;;;;'\r\n" + 
						"        (.-~___     \\.'|    | /-.__.-\\|::::| //~     ,;;;;/;;;;;'\r\n" + 
						"        /      ~~--._ \\|   /          `\\:: |/      ,;;;;/;;;;;'\r\n" + 
						"     .-|             ~~|   |  /V\"\"\"\"V\\ |:  |     ,;;;;/;;;;;' \\\r\n" + 
						"    /                   \\  |  ~`^~~^'~ |  /    ,;;;;/;;;;;'    ;\r\n" + 
						"   (        \\             \\|`\\._____./'|/    ,;;;;/;;;;;'      '\\\r\n" + 
						"  / \\        \\                             ,;;;;/;;;;;'     /    |\r\n" + 
						" |            |                          ,;;;;/;;;;;'      |     |\r\n" + 
						"|`-._          |                       ,;;;;/;;;;;'              \\\r\n" + 
						"|             /                      ,;;;;/;;;;;'  \\ \\__________\r\n" + 
						"(             )                 |  ,;;;;/;;;;;'      |        _.--~");

			}
		}
	

	class kobold implements Monster{
		
		
		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(225);
			dmg.add(45);
			res.add(25);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("     _                  _\r\n" + 
					"    | '-.            .-' |\r\n" + 
					"    | -. '..\\\\,.//,.' .- |\r\n" + 
					"    |   \\  \\\\\\||///  /   |\r\n" + 
					"   /|    )M\\/%%%%/\\/(  . |\\\r\n" + 
					"  (/\\  MM\\/%/\\||/%\\\\/MM  /\\)\r\n" + 
					"  (//M   \\%\\\\\\%%//%//   M\\\\)\r\n" + 
					"(// M________ /\\ ________M \\\\)\r\n" + 
					" (// M\\ \\(',)|  |(',)/ /M \\\\) \\\\\\\\  \r\n" + 
					"  (\\\\ M\\.  /,\\\\//,\\  ./M //)\r\n" + 
					"    / MMmm( \\\\||// )mmMM \\  \\\\\r\n" + 
					"     // MMM\\\\\\||///MMM \\\\ \\\\\r\n" + 
					"      \\//''\\)/||\\(/''\\\\/ \\\\\r\n" + 
					"      mrf\\\\( \\oo/ )\\\\\\/\\\r\n" + 
					"           \\'-..-'\\/\\\\\r\n" + 
					"              \\\\/ \\\\");

		}

		@Override
		public void skill(int a) {
			// TODO Auto-generated method stub
			System.out.println();
			System.out.println("Kobold grows mad overtime!");
			System.out.println("Damage up by 20 every turn!");
			
			int x = dmg.get(level);
			x = x + 20;
			dmg.set(level, x);
		}
	}
	
	class ogre implements Monster{
		

		@Override
		public void status() {
			// TODO Auto-generated method stub
			hp.add(200);
			dmg.add(20);
			res.add(30);
		}

		@Override
		public void pic() {
			// TODO Auto-generated method stub
			System.out.println("                           __,='`````'=/__\r\n" + 
					"                          '//  (o) \\(o) \\ `'         _,-,\r\n" + 
					"                          //|     ,_)   (`\\      ,-'`_,-\\\r\n" + 
					"                        ,-~~~\\  `'==='  /-,      \\==```` \\__\r\n" + 
					"                       /        `----'     `\\     \\       \\/\r\n" + 
					"                    ,-`                  ,   \\  ,.-\\       \\\r\n" + 
					"                   /      ,               \\,-`\\`_,-`\\_,..--'\\\r\n" + 
					"                  ,`    ,/,              ,>,   )     \\--`````\\\r\n" + 
					"                  (      `\\`---'`  `-,-'`_,<   \\      \\_,.--'`\r\n" + 
					"                   `.      `--. _,-'`_,-`  |    \\\r\n" + 
					"                    [`-.___   <`_,-'`------(    /\r\n" + 
					"                    (`` _,-\\   \\ --`````````|--`\r\n" + 
					"                     >-`_,-`\\,-` ,          |\r\n" + 
					"                   <`_,'     ,  /\\          /\r\n" + 
					"                    `  \\/\\,-/ `/  \\/`\\_/V\\_/\r\n" + 
					"                       (  ._. )    ( .__. )\r\n" + 
					"                       |      |    |      |\r\n" + 
					"                        \\,---_|    |_---./\r\n" + 
					"                        ooOO(_)    (_)OOoo");

		}

		@Override
		public void skill(int a) {
			// TODO Auto-generated method stub
			int x = hp.get(a);
			x = x + 30;
			hp.set(a, x);
			System.out.println("Ogre's passive activated! HP +30 every turn");
		}
	}
	

	class charskillset {
	public void hs(int a) {
		int x = hp.get(a);
		int y = dmg.get(0);
		int z = res.get(a);
		mana = mana - 25;
		
		x = x - ((y * (1-(z/100))) * 2) ;
		
		hp.set(a, x);
		
		System.out.println();
		System.out.println("Dealt " + (y * (1-(z/100)))*2 + " dmg");
	}
	
	public void ca(int a){
		int x = res.get(a);
		x = x / 2;
		res.set(a, x);
		mana = mana - 40;
		System.out.println();
		System.out.println("Reduced enemy resistance by 50%");
	}
	
	public void ber() {
		int x = hp.get(0);
		int y = dmg.get(0);
		int z = res.get(0);
		
		x = x * 2;
		y = (int) (y * 1.5);
		z = (int) (z * 0.5);
		
		hp.set(0, x);
		res.set(0, z);
		dmg.set(0, y);
		
		mana = mana - 50;
		
		System.out.println();
		System.out.println("You have been blessed by the War God!");
	}
}
	
	private void welcome() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome to Monster Slayer!");
		System.out.println("Enter '1' to start!");
		System.out.print(">> ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
