/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loveCalculator;
//comment line
public class FromStringToInteger {

	String name1, name2, together, inLove;

    
	int broj;

	public void racunanje() {
		together = name1.toLowerCase() + name2.toLowerCase();

		
		// Brojanje koliko s pojedini brojevi ponavljalju

		int ch[] = new int[together.length()];
		for (int i = 0; i < together.length(); i++) {
			int brojac = 0;
			for (int j = 0; j < together.length(); j++) {
				if (together.charAt(j) == together.charAt(i)) {
					brojac++;
				}
			}
			ch[i] = brojac;

		}
		
		//Provjera jesu li elementi ispravno upisani u niz
//		for (int i = 0; i < ch.length; i++) {
//			System.out.print(ch[i] + " ");
//			
//		}

		int prviKorak = ch.length;

		
		//postavljam neki broj koji je veći od 100 tako da uđe u while petlju
		//a dalje ga kontrolira broj koji se nalazi unutra
		
		inLove = "1000";



		while ((Integer.parseInt(inLove))>100) {

			
			// Ukoliko je niz brojeva neparan broj, ostat će mi jedan element kojeg upisujem na kraj
			if (prviKorak % 2 != 0) {
				inLove = "";
				for (int i = 0; i < prviKorak / 2; i++) {
					inLove += String.valueOf((ch[i]) + (ch[prviKorak - 1 - i]));
				}
				inLove += String.valueOf(ch[(prviKorak / 2)]);
				prviKorak = inLove.length();
				for (int i = 0; i < prviKorak; i++) {

					// Sprječavanje greške MIN_RADIX koja se događa kada se koristi parseInt za
					// stringove 0 i 1.
					if (inLove.substring((i), (i + 1)) == "0") {
						ch[i] = 0;

					} else if (inLove.substring((i), (i + 1)) == "1") {
						ch[i] = 1;
					}

					else {
						ch[i] = Integer.parseInt(inLove.substring((i), (i + 1)));
					}

				}
			} 
			//Ukoliko je niz brojeva paran broj, zbrajam prvi za zadnjim elementom i tako se pomićem prema sredini
			else if (prviKorak % 2 == 0) {
				inLove = "";
				for (int i = 0; i < prviKorak / 2; i++) {
					inLove += String.valueOf((ch[i]) + (ch[prviKorak - 1 - i]));
				}
				prviKorak = inLove.length();
				for (int i = 0; i < prviKorak; i++) {

					// Sprječavanje greške MIN_RADIX koja se događa kada se koristi parseInt za
					// stringove 0 i 1.
					if (inLove.substring((i), (i + 1)) == "0") {
						ch[i] = 0;

					} else if (inLove.substring((i), (i + 1)) == "1") {
						ch[i] = 1;
					}

					else {
						ch[i] = Integer.parseInt(inLove.substring((i), (i + 1)));
					}

				}
		
			}

			

		}
		
		//Ispis koliko su posto zaljubljeni
		System.out.println("\nLjubavni par " + name1 + " & " + name2 + " zaljubljeni su " + inLove+"%.");
	}

	public int getBroj() {
		racunanje();
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String ime1) {
		this.name1 = ime1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String ime2) {
		this.name2 = ime2;
	}
        public String getInLove() {
        return inLove;
    }

    public void setInLove(String inLove) {
        this.inLove = inLove;
    }

}
