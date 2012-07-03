package com.ghp2012.monopoly.game;

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
