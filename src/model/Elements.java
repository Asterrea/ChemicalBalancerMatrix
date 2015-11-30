package model;

public enum Elements {
	H ("Hydrogen",		"H",	1),		HE("Helium",		"He",	2),		LI("Lithium",		"Li",	3),
	BE("Beryllium",		"Be",	4),		B ("Boron",			"B",	5),		C ("Carbon",		"C",	6),
	N ("Nitrogen",		"N",	7),		O ("Oxygen",		"O",	8),		F ("Fluorine",		"F",	9),
	NE("Neon",			"Ne",	10),	NA("Sodium",		"Na",	11),	MG("Magnesium",		"Mg",	12),
	AL("Aluminum",		"Al",	13),	SI("Silicon",		"Si",	14),	P ("Phosphorus",	"P",	15),
	S ("Sulfur",		"S",	16),	CL("Chlorine",		"Cl",	17),	AR("Argon",			"Ar",	18),
	K ("Potassium",		"K",	19),	CA("Calcium",		"Ca",	20),	SC("Scandium",		"Sc",	21),
	TI("Titanium",		"Ti",	22),	V ("Vanadium",		"V",	23),	CR("Chromium",		"Cr",	24),
	MN("Manganese",		"Mn",	25),	FE("Iron",			"Fe",	26),	CO("Cobalt",		"Co",	27),
	NI("Nickel",		"Ni",	28),	CU("Copper",		"Cu",	29),	ZN("Zinc",			"Zn",	30),
	GA("Gallium",		"Ga",	31),	GE("Germanium",		"Ge",	32),	AS("Arsenic",		"As",	33),
	SE("Selenium",		"Se",	34),	BR("Bromine",		"Br",	35),	KR("Krypton",		"Kr",	36),
	RB("Rubidium",		"Rb",	37),	SR("Strontium",		"Sr",	38),	Y ("Yttrium",		"Y",	39),
	ZR("Zirconium",		"Zr",	40),	NB("Niobium",		"Nb",	41),	MO("Molybdenum",	"Mo",	42),
	TC("Technetium",	"Tc",	43),	RU("Ruthenium",		"Ru",	44),	RH("Rhodium",		"Rh",	45),
	PD("Palladium",		"Pd",	46),	AG("Silver",		"Ag",	47),	CD("Cadmium",		"Cd",	48),
	IN("Indium",		"In",	49),	SN("Tin",			"Sn",	50),	SB("Antimony",		"Sb",	51),
	TE("Tellurium",		"Te",	52),	I ("Iodine",		"I",	53),	XE("Xenon",			"Xe",	54),
	CS("Caesium",		"Cs",	55),	BA("Barium",		"Ba",	56),	LA("Lanthanum",		"La",	57),
	CE("Cerium",		"Ce",	58),	PR("Praseodymium",	"Pr",	59),	ND("Neodymium",		"Nd",	60),
	PM("Promethium",	"Pm",	61),	SM("Samarium",		"Sm",	62),	EU("Europium",		"Eu",	63),
	GD("Gadolinium",	"Gd",	64),	TB("Terbuim",		"Tb",	65),	DY("Dysprosium",	"Dy",	66),
	HO("Holmium",		"Ho",	67),	ER("Erbium",		"Er",	68),	TM("Thulium",		"Tm",	69),
	YB("Ytterbium",		"Yb",	70),	LU("Lutetium",		"Lu",	71),	HF("Hafnium",		"Hf",	72),
	TA("Tantalum",		"Ta",	73),	W ("Tangsten",		"W",	74),	RE("Rhenium",		"Re",	75),
	OS("Osmium",		"Os",	76),	IR("Iridium",		"Ir",	77),	PT("Platinum",		"Pt",	78),
	AU("Gold",			"Au",	79),	HG("Mercury",		"Hg",	80),	TL("Thallium",		"Tl",	81),
	PB("Lead",			"Pb",	82),	BI("Bismuth",		"Bi",	83),	PO("Polonium",		"Po",	84),
	AT("Astatine",		"At",	85),	RN("Radon",			"Rn",	86),	FR("Francium",		"Fr",	87),
	RA("Radium",		"Ra",	88),	AC("Actinium",		"Ac",	89),	TH("Thorium",		"Th",	90),
	PA("Protactinium",	"Pa",	91),	U ("Uranium",		"U",	92),	NP("Neptunium",		"Np",	93),
	PU("Plutonium",		"Pu",	94),	AM("Americium",		"Am",	95),	CM("Curium",		"Cm",	96),
	BK("Berkelium",		"Bk",	97),	CF("Californium",	"Cf",	98),	ES("Einsteinium",	"Es",	99),
	FM("Fermium",		"Fm",	100),	MD("Mendelevium",	"Md",	101),	NO("Nobelium",		"No",	102),
	LR("Lawrencium",	"Lr",	103),	RF("Rutherfordium",	"Rf",	104),	DB("Dubnium",		"Db",	105),
	SG("Seaborgium",	"Sg",	106),	BH("Bohrium",		"Bh",	107),	HS("Hassium",		"Hs",	108),
	MT("Meitnerium",	"Mt",	109),	DS("Darmstadtium",	"Ds",	110),	RG("Roentgenium",	"Rg",	111),
	CN("Copernicium",	"Cn",	112),	UUT("Ununtrium",	"Uut",	113),	FL("Flerovium",		"Fl",	114),
	UUP("Ununpentium",	"Uup",	115),	LV("Livermorium",	"Lv",	116),	UUS("Ununseptium",	"Uus",	117),
	UUO("Ununoctium",	"Uuo",	118);
	
	
	private final String name;
	private final String abbrev;
	private final int atomNum;
	
	private Elements(String name, String abbrev, int atomNum){
		this.name = name;
		this.abbrev = abbrev;
		this.atomNum = atomNum;
	}
	
	public String getElementName(){
		return name;
	}
	
	public String getElementAbbrev(){
		return abbrev;
	}
	
	public int getAtomicNumber(){
		return atomNum;
	}
}
