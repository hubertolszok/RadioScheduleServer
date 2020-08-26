public class Program {

	public static final String[][] RNS = { 
			{ "0", "Muzyka", "Krzysztof Sacha" },
			{ "600", "Nowy swit", "Katarzyna Kasia i Grzegorz Markowski" },
			{ "1000", "Probny lot", "finalista konkursu organizowanego przez rozg³oœniê" },
			{ "1100", "W srodku dnia", "Mateusz Adruszkiewicz, Krzysztof Sacha, Maciej Jankowski i Karol Berger" },
			{ "1400", "Muzyka bardzo powazna", "Krzysztof Grabowski" },
			{ "1600", "Popo³udnie w Nowym Œwiecie", "Micha³ Porycki, wydawca: Ksenia Maæczak" },
			{ "1900", "Strumieñ zdumieñ", "Jan Chojnacki" }, 
			{ "2100", "Punkt widzenia", "Krzysztof Sacha" },
			{ "2200", "Muzyka", "Krzysztof Sacha" }, };

	public static final String[][] RMFFM = { 
			{ "0", "Dobra nocka latem", "" },
			{ "600", "Wstawaj, szkoda lata", "Przemys³aw Skowron, Tomasz Olbratowski i Mariusz Ka³amaga" },
			{ "1000", "Lato wszêdzie", "Aleksandra Filipek" }, { "1430", "Czas Letni", "Jacek Tomkowicz" },
			{ "1900", "Poplista plus wakacje", "Darek Maciborek" }, };

	public static void main(String[] args) {
		String test = "11200";
		System.out.println(decrypt(test));

		test = "21200";
		System.out.println(decrypt(test));

		test = "31200";
		System.out.println(decrypt(test));

		test = "22990";
		System.out.println(decrypt(test));

	}

	public static String decrypt(String clientMessage) {
		String answer = "";
		int p = 0;
		String[][] table;
		int stationNumber = Integer.parseInt(clientMessage.substring(0, 1));
		int time = Integer.parseInt(clientMessage.substring(1));

		if (stationNumber == 1 | stationNumber == 2) {
			if (time >= 0 & time <= 2400) {

				switch (stationNumber) {
				case 1:
					table = RNS;
					break;
				case 2:
					table = RMFFM;
					break;
				default:
					table = RNS;
					break;
				}

				for (int i = 0; p == 0; i++) {
					if (time < Integer.parseInt(table[i][0])) {
						p = i;
						break;
					}

				}
				p = p - 1;

				return "Audycja " + table[p][1] + " prowadzi " + table[p][2];
			} else {
				return "Bledny czas";
			}
		} else {
			return "Nie znana stacja radiowa";
		}

	}

}
