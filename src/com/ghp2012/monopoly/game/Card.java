package com.ghp2012.monopoly.game;

import com.ghp2012.monopoly.sim.MonopolySimulation;

/**
 * Superclass for chance and community chest cards.
 * 
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Card {
	public enum ChanceCard {
		ADV_TO_GO(new Card("adv_to_go", "Advance to Go (Collect $200)", true)), ADV_ILLINOIS_AVE(
				new Card(
						"adv_illinois_ave",
						"Advance to Illinois Ave - if you pass Go, collect $200",
						true)), ADV_UTILITY(
				new Card(
						"adv_utility",
						"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.",
						true)), ADV_RAILROAD_1(
				new Card(
						"adv_railroad_1",
						"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.",
						true)), ADV_RAILROAD_2(
				new Card(
						"adv_railroad_2",
						"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.",
						true)), ADV_ST_CHARLES(new Card("adv_st_charles",
				"Advance to St. Charles Place – if you pass Go, collect $200",
				true)), DIVIDEND(new Card("dividend",
				"Bank pays you dividend of $50", true)), GET_OUT_FREE(
				new Card(
						"get_out_free",
						"Get out of Jail Free – this card may be kept until needed, or traded/sold",
						false)), GO_BACK(new Card("go_back",
				"Go back 3 spaces", true)), GO_TO_JAIL(new Card("go_to_jail",
				"Go directly to Jail – do not pass Go, do not collect $200",
				true)), REPAIRS(
				new Card(
						"make_repairs",
						"Make general repairs on all your property – for each house pay $25 – for each hotel $100",
						true)), PAY_TAX(new Card("pay_tax",
				"Pay poor tax of $15", true)), READING_RAILROAD(
				new Card(
						"reading_railroad",
						"Take a trip to Reading Railroad – if you pass Go, collect $200",
						true)), BOARDWALK(new Card("boardwalk",
				"Take a walk on the Boardwalk – advance token to Boardwalk",
				true)), CHAIRMAN_OF_BOARD(
				new Card(
						"chairman",
						"You have been elected chairman of the board – pay each player $50",
						true)), BUILDING_LOAN(new Card("building_loan",
				"Your building loan matures – collect $150", true)), CROSSWORD(
				new Card("crossward",
						"You have won a crossword competition - collect $100",
						true));

		public final Card card;

		private ChanceCard(Card c) {
			card = c;
		}

		public void doCard(Player p, MonopolySimulation sim, GameBoard board) {
			switch (this) {
			case REPAIRS:
				switch (MonopolySimulation.numHouses) {
				case 1:
					p.changeMoney(-25 * p.numProps());
					break;
				case 2:
					p.changeMoney(-50 * p.numProps());
					break;
				case 3:
					p.changeMoney(-75 * p.numProps());
					break;
				case 4:
					p.changeMoney(-100 * p.numProps());
					break;
				case 5:
					p.changeMoney(-100 * p.numProps());
					break;
				default:
					break;
				}
				break;
			case READING_RAILROAD:
				if (p.getLocation() > 5)
					p.changeMoney(200);
				p.setLocation(5);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case PAY_TAX:
				p.changeMoney(-15);
				break;
			case ADV_ILLINOIS_AVE:
				if (p.getLocation() > 24)
					p.changeMoney(200);
				p.setLocation(24);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case GO_TO_JAIL:
				p.setLocation(10);
				p.setTurnsInJail(0);
				p.setInJail(true);
				break;
			case GO_BACK:
				p.setLocation(p.getLocation() - 3);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case GET_OUT_FREE:
				p.setHasChanceJailCard(true);
				break;
			case DIVIDEND:
				p.changeMoney(50);
				break;
			case CROSSWORD:
				p.changeMoney(100);
				break;
			case CHAIRMAN_OF_BOARD:
				p.changeMoney(-50 * (board.getPlayers().size() - 1));
				for (Player i : board.getPlayers())
					i.changeMoney(50);
				break;
			case BUILDING_LOAN:
				p.changeMoney(150);
				break;
			case BOARDWALK:
				p.setLocation(39);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case ADV_UTILITY:
				if (p.getLocation() < 12)
					p.setLocation(12);
				else if (p.getLocation() < 28)
					p.setLocation(28);
				else {
					p.setLocation(12);
					p.changeMoney(200);
				}
				sim.processSpace(p, p.getLocation(), board.rollDice());
				break;
			case ADV_TO_GO:
				p.setLocation(0);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case ADV_ST_CHARLES:
				if (p.getLocation() > 11)
					p.changeMoney(200);
				p.setLocation(11);
				sim.processSpace(p, p.getLocation(), null);
				break;
			case ADV_RAILROAD_2:
			case ADV_RAILROAD_1:
				if (p.getLocation() < 5)
					p.setLocation(5);
				else if (p.getLocation() < 15)
					p.setLocation(15);
				else if (p.getLocation() < 25)
					p.setLocation(25);
				else if (p.getLocation() < 35)
					p.setLocation(35);
				else {
					p.setLocation(5);
					p.changeMoney(200);
				}
				sim.processSpace(p, p.getLocation(), null);
				break;
			}
		}
	}

	public enum CommunityChestCard {
		ADV_TO_GO(new Card("adv_to_go", "Advance to Go (Collect $200) ", true)), BANK_ERROR_IN_FAVOR(
				new Card("bank_error_in_favor",
						"Bank error in your favor, collect $200 ", true)), DOCTOR_FEES(
				new Card("doctor_fees", "Doctor's fees, Pay $50 ", true)), OUT_OF_JAIL(
				new Card(
						"out_of_jail",
						"Get Out of Jail Free, this card may be kept until needed, or sold",
						false)), GO_TO_JAIL(
				new Card(
						"go_to_jail",
						"Go to Jail, go directly to jail, Do not pass Go, do not collect $200 ",
						true)), BIRTHDAY(new Card("birthday",
				"It is your birthday - Collect $10 from each player ", true)), GRAND_OPERA(
				new Card(
						"grand_opera",
						"Grand Opera Night, collect $50 from every player for opening night seats",
						true)), INCOME_TAX_REFUND(new Card("income_tax_refund",
				"Income Tax refund, collect $20 ", true)), LIFE_INSURANCE_MATURES(
				new Card("life_insurance_matures",
						"Life Insurance Matures, collect $100 ", true)), PAY_HOSPITAL_FEES(
				new Card("pay_hospital_fees", "Pay Hospital Fees of $100 ",
						true)), PAY_SCHOOL_FEES(new Card("pay_school_fees",
				"Pay School Fees of $50 ", true)), RECEIVE_CONSULTANCY_FEE(
				new Card("receive_consultancy_fee",
						"Receive $25 Consultancy Fee ", true)), STREET_REPAIRS(
				new Card(
						"street_repairs",
						"You are assessed for street repairs , $40 per house, $115 per hotel ",
						true)), SECOND_PRIZE_BEAUTY(new Card(
				"second_prize_beauty",
				"You have won second prize in a beauty contest, collect $10 ",
				true)), INHERITANCE(new Card("inheritance",
				"You inherit $100 ", true)), SALE_OF_STOCK(new Card(
				"sale_of_stock", "From sale of stock you get $50 ", true)), HOLIDAY_FUND_MATURES(
				new Card("holiday_fund_matures",
						"Holiday Fund matures - Receive $100 ", true));

		public final Card card;

		private CommunityChestCard(Card c) {
			card = c;
		}
	}

	private String name;
	private String description;
	private boolean replace = true;

	public boolean shouldReplace() {
		return replace;
	}

	public Card(String name, String description, boolean replace) {
		this.name = name;
		this.description = description;
		this.replace = replace;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
