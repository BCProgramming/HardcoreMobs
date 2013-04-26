package com.BASeCamp.HardcoreMobs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import org.bukkit.ChatColor;

import com.BASeCamp.HardcoreMobs.HardcoreMobs;
import com.BASeCamp.HardcoreMobs.RandomData;

import BASeCamp.Configuration.INIFile;
import BASeCamp.Configuration.INISection;


//Special class for generating Item names.

public class NameGenerator {

	public List<String> MobNames = new LinkedList<String>(Arrays.asList(
	"Timmy","Bobby","Wally","Peter","Chris","Chuck","Ralph","Paul","Richard","Ted","Shawn","Sean",
	"Will","Willard","Daphne","Kelsey","Mitchell","Milton","Millbee","Hugo","Quinton","Quincy","Z'ul",
	"Bradley","Vlad","Vestilu","Biff","Marty","Rupert","Dave","Thomas","Goliath","Andy","Anne","Cain","Isaac","Adam"));
	public List<String> MobTitles = new LinkedList<String>(Arrays.asList("Vindicating","Bad","Terrible","Evil","Teabaggery","Uncouthery","Unpleasantry","Tomfoolery",
		"Surgery","Study"));
	
	public List<String> Books = new LinkedList<String>(Arrays.asList("Tome","Book","Volume","Parchment","Scroll"));
	public List<String> Hats = new LinkedList<String>(Arrays.asList("Hat","Cap","Helmet","Topper","Fez","Sombrero"));
	public List<String> Chestplates = new LinkedList<String>(Arrays.asList(
			"Chestplate","Mail","Tunic","Shirt","Blouse","Tank-top","Potato sack","Jersey","Pullover","Sweater","Turtleneck"));
	public List<String> Pants = new LinkedList<String>(Arrays.asList(
			"Leggings","Pants","Greaves","Trousers","Britches","Slacks","Pantaloons"));
	public List<String> Boots = new LinkedList<String>(Arrays.asList("Boots","Shoes","Flip-Flops","Clogs","Booties","Moccasins","Sneakers","Cleats","Loafers","Slippers"));
	public List<String> Sword = new LinkedList<String>(Arrays.asList(
			"Slasher","Sword","Blade","Slicer","Cutter","Katana","Cutlass","Foil","Rapier","Scimitar","Knife","Bodkin"));
	public List<String> Axe = new LinkedList<String>(Arrays.asList(
			"Battle Axe","Axe","Hatchet","Woodcutter"));
	public List<String> Pickaxe = new LinkedList<String>(Arrays.asList(
			"Pick","Pickaxe","Pickaxe","Pickaxe","Pickaxe","Nosepicker"));
	
	public static String GeneratorINI =  "namegen.ini";
	
	public List<String> Bow = new LinkedList<String>(Arrays.asList("Shooter","Dealer", "Bow","Piercer","Hunting Bow","Nightingale Bow","Dart Shooter"));
	
	public List<String> Nouns = new LinkedList<String>(Arrays.asList( 
"accounts","achievers","acoustics","acts","actions","activities","actors","additions","adjustments",
		"advertisements","advice","aftermath","afternoons","afterthoughts","agreements","airplanes",
		"airports","alarms","amounts","amusements","angers","angles","animals","answers","ants","apparatus",
		"apparel","apples","appliances","approvals","arches","arguments","arithmetic","arms","armies","art",
		"attacks","attempts","attention","attraction","aunts","authorities","babies","badges","budgees","bags",
		"baits","balances","balloons","balls","bananas","bands","bases","baseballs","baskets","basketballs",
		"bats","baths","battles","beads","beams","beans","bears","beasts","beds","bedrooms","bees","beef",
		"beetles","beggars","beginners","behaviours","beliefs","bells","berries","bikes","birds","births",
		"birthdays","bits","bites","blades","bloods","blows","boards","boats","bodies","bombs","bones",
		"books","boots","borders","bottles","boundaries","boxes","boys","brains","brakes","branches",
		"brass","breads","breakfasts","bricks","bridges","brothers","brushes","bubbles","buckets",
		"buildings","bulbs","buns","burns","bushes","businesses","butters","buttons","cabbages",
		"cables","cactuses","cakes","calculators","calendars","cameras","camps","cans","cannons",
		"canvases","caps","captions","cars","cards","carpenters","carriages","carts","casts","cats",
		"cattle","causes","caves","celery","cellars","cemeterys","cents","chains","chalks","chances",
		"changes","channels","cheeses","cherries","chess","chickens","children","chins","churches",
		"circles","clams","classes","clocks","cloth","clouds","clovers","clubs","coaches","coal",
		"coasts","coats","cobwebs","coils","collars","colors","combs","comforts","committees","companies",
		"comparisons","competitions","conditions","connections","controls","cooks","coppers","copies","cords",
		"corks","corns","coughs","countries","covers","cows","cracks","crackers","crates","crayons","creams",
		"creators","creature","credits","cribs","crimes","crooks","crows","crowds","crowns","crushes","cries",
		"cubs","cups","currents","curtains","curves","cushions","dads","daughters","days","deaths","debts",
		"decisions","deers","degrees","designs","desires","desks","destructions","details","developments",
		"digestions","dimes","dinners","dinosaurs","directions","dirts","discoveries","discussions","diseases",
		"disgusts","distances","distributions","divisions","docks","doctors","dogs","dolls","donkeys","doors",
		"drains","drawers","dresses","drinks","drivers","drops","drugs","drums","ducks","ears","earth","earthquakes",
		"edges","education","effects","eggs","eggnogs","eggs","elbows","ends","engines","errors","events","examples",
		"exchanges","existences","expansions","experiences","experts","eyes","eyes","faces","facts","fairies",
		"falls","families","fans","fangs","farms","farmers","fathers","faucets","fears","feasts","feathers",
		"feelings","feet","fictions","fields","fifths","fights","fingers","fires","firemans","fish","flags",
		"flames","flavors","fleshes","flights","flocks","floors","flowers","flies","fogs","folds","foods",
		"foots","forces","forks","forms","fowls","frames","frictions","friends","frogs","fronts","fruits",
		"fuels","furnitures","alleies","games","gardens","gates","geese","ghosts","giants","giraffes",
		"girls","glasses","gloves","glues","goats","golds","goldfishes","good-byes","gooses","governments",
		"governors","grades","grains","grandfathers","grandmothers","grapes","grasses","grips","grounds",
		"groups","growths","guides","guitars","guns","hairs","haircuts","halls","hammers","hands",
		"harbors","harmonies","hats","hates","heads","healths","hearings","hearts","heats","helps",
		"hens","hills","histories","hobbies","holes","holidays","homes","honeies","hooks","hopes",
		"horns","horses","horsess","hoses","hospitals","hots","hours","houses","humors","hydrants",
		"ices","icicles","ideas","impulses","incomes","increases","industries","inks","insects","instruments",
		"insurances","interests","inventions","irons","islands","jails","jams","jars","jellies","jellyfishes",
		"jewels","joins","jokes","journeys","judges","juices","jumps","kettles","keies","kicks","kisses",
		"kites","kittens","kitties","knees","knifes","knots","knowledges","laborers","laces","ladybugs",
		"lakes","lamps","lands","languages","laughs","lawyers","leads","leafs","learnings","leathers",
		"legs","legss","letters","lettuces","levels","libraries","lifts","lights","limits","lines","linens",
		"lips","liquids","lists","loafs","locks","lockets","looks","losses","loves","lows","lumbers","lunches",
		"lunchrooms","machines","magics","maids","mailboxs","mans","managers","maps","marbles","marks",
		"markets","masks","masses","matchs","meals","measures","meats","meetings","memories","mens","metals",
		"mices","middles","milks","minds","mines","ministers","mints","minutes","mists","mittens","moms",
		"moneys","monkeys","months","moons","mornings","mothers","motions","mountains","mouths","moves",
		"muscles","musics","nails","names","nations","necks","needs","needles","nerves","nests","nets",
		"news","nights","noises","norths","noses","notes","notebooks","numbers","nuts","oatmeals",
		"observations","oceans","offers","offices","oils","operations","opinions","oranges","orders",
		"organizations","ornaments","ovens","owls","owners","pages","pails","pains","paints","pans",
		"pancakes","papers","parcels","parents",
		"parks","parts","partners","parties","passengers","pastes","patchs","payments","peaces","pears",
		"pens","pencils","persons","pests","pets","petss","pickles","pictures","pies","pigs","pins",
		"pipes","pizzas","places","planes","planess","plants","plantations","plantss","plastics","plates",
		"plays","playgrounds","pleasures","plots","ploughs","pockets","points","poisons","police",
		"polishes","pollutions","popcorns","porters","positions","pots","potatoes","powders","powers",
		"prices","prints","prisons","processes","produce","profits","properties","proses","protests",
		"pulls","pumps","punishments","purposes","pushes","quarters","quartz","queens","questions",
		"quicksand","quiets","quills","quilts","quinces","quivers","rabbits","rails","railways","rains",
		"rainstorms","rakes","ranges","rats","rates","raies","reactions","readings","reasons","receipts",
		"recesses","records","regrets","relations","religions","representatives","requests","respects",
		"rests","rewards","rhythms","rice","riddles","rifles","rings","rings","rivers","roads","robins",
		"rocks","rods","rolls","roofs","rooms","roots","roses","routes","rubs","rules","runs","sacks",
		"sails","salts","sands","scales","scarecrows","scarfs","scenes","scents","schools","sciences",
		"scissors","screws","seas","seashores","seats","secretaries","seeds","selections","selfs","senses",
		"servants","shades","shakes","shames","shapes","sheeps","sheets","shelfs","ships","shirts","shocks",
		"shoes","shoess","shops","shows","sides","sidewalks","signs","silks","silvers","sinks","sisters",
		"sizes","skates","skins","skirts","skies","slaves","sleeps","sleets","slips","slopes","smashes",
		"smells","smiles","smokes","snails","snailss","snakes","snakess","sneezes","snows","soaps",
		"societies","socks","sodas","sofas","sons","songs","sorts","sounds","soups","spaces","spades",
		"sparks","spiders","sponges","spoons","spots","springs","spies","squares","squirrels","stages",
		"stamps","stars","starts","statements","stations","steams","steels","stems","steps","stews",
		"sticks","stitchs","stockings","stomachs","stones","stops","stores","stories","stoves","strangers",
		"straws","streams","streets","stretchs","strings","structures","substances","sugars","suggestions",
		"suits","summers","suns","supports","surprises","sweaters","swims","swings","systems","tables",
		"tails","talks","tanks","tastes","taxs","teachings","teams","teeths","tempers","tendencies","tents",
		"territories","tests","textures","theories","things","thoughts","threads","thrills","throats",
		"thrones","thumbs","thunders","tickets","tigers","times","tins","titles","toads","toes","tongues",
		"toothbrushes","toothpastes","tops","touches","towns","toys","trades","trails","trains","tramps",
		"transports","trays","treatments","trees","tricks","trips","troubles","trousers","trucks","tubs",
		"turkeys","turns","twigs","twists","umbrellas","uncles","underwear","units","uses","vacations",
		"values","vans","vases","vegetables","veils","veins","verses","vessels","vests","views","visitors",
		"voices","volcanos","volleyballs","voyages","walks","walls","wars","washes","wastes","watchs",
		"waters","waves","wavess","waxs","ways","wealths","weathers","weeks","weights","wheels","whips",
		"whistles","wildernesses","winds","windows","wines","wings","winters","wires","wishes","women",
		"woods","wools","words","works","worms","wounds","wrens","wrenchs","wrists","writers","writing"));
	public List<String> Verbs = new LinkedList<String>(Arrays.asList(
	                                         
 "accepting","addition","admiration","admission","advising","affording","alerting","allowing",
		"amusing","analysing","announcing","annoying","answering","apologising","appearing","applauding",
		"appreciating","approving","arguing","arranging","arresting","arriving","asking","attaching",
		"attacking","attempting","attending","attracting","avoiding","backing","baking","balancing",
		"baning","banging","baring","bating","bathing","battling","beaming","begging","behaving",
		"belonging","bleaching","blessing","blinding","blinking","blotting","blushing","boasting",
		"boiling","bolting","bombing","booking","boring","borrowing","bouncing","boxing","braking",
		"branching","breathing","bruising","brushing","bubbling","bumping","burning","burying","buzzing",
		"calculating","calling","camping","caring","carrying","carving","causing","challenging",
		"changing","charging","chasing","cheating","checking","cheering","chewing","choking",
		"chopping","mastication","claiming","claping","cleaning","clearing","clipping",
		"closing","coaching","coiling","collecting","colouring","combing","commanding",
		"communicating","comparing","competing","complaining","completing","concentrating",
		"concerning","confession","confusing","connecting","considering","consisting","containing",
		"continuing","copying","correcting","coughing","counting","covering","cracking","crashing",
		"crawling","crossing","crushing","crying","curing","curling","curving","cycling","damning",
		"damaging","dancing","daring","decaying","deceiving","deciding","decorating","delaying",
		"delighting","delivering","depending","describing","deserting","deserving","destroying",
		"detecting","developing","disagreement","disappearing","disapproving","disarming",
		"discovering","disliking","dividing","doubling","doubting","dragging","draining",
		"dreaming","dressing","dripping","dropping","drowning","druming","drying","dusting",
		"earning","educating","embarrassing","employing","emptying","encouraging","ending",
		"enjoying","entering","entertaining","escaping","examining","exciting","excusing",
		"exercising","existing","expanding","expecting","explaining","exploding","extending",
		"facing","fading","failing","fancying","fastening","faxing","fearing","fencing",
		"fetching","filing","filling","filming","firing","fitting","fixing","flapping",
		"flashing","floating","flooding","flowing","flowering","folding","following",
		"fooling","forcing","forming","founding","framing","frightening","frying",
		"gathering","gazing","glowing","gluing","grabing","grating","greasing",
		"greeting","grining","griping","groaning","guaranteeing","guarding",
		"guessing","guiding","hammering","handing","handling","hanging","happening","harassing",
		"harming","hating","haunting","beheading","healing","heaping","heating","helping","hooking",
		"hoping","hovering","hugging","humming","hunting","hurrying","identifying","ignoring","imagining",
		"impressing","improving","including","increasing","influencing","informing","injecting","injuring",
		"instructing","intending","interesting","interfering","interrupting","introducing","inventing",
		"inviting","irritating","itching","jailing","jaming","jogging","joining","joking","judging","juggling",
		"jumping","kicking","killing","kissing","kneeling","knitting","knocking","knotting","labeling",
		"landing","lasting","laughing","launching","learning","leveling","licensing","licking","lightening",
		"liking","listing","listening","living","loading","locking","longing","looking","loving","managing",
		"marching","marking","marrying","matching","mating","mattering","measuring","meddling","melting",
		"memorising","mending","mess uping","milking","mining","missing","mixing","moaning","mooring",
		"mourning","moving","muddling","mugging","multiplication","murdering","nailing","naming","needing",
		"nesting","noding","noting","noticing","numbering","obeying","objecting","observing","obtaining",
		"occuring","offending","offering","opening","ordering","overflowing","owing","owning","packing",
		"paddling","painting","parking","parting","passing","pasting","pating","pausing","pecking","pedaling",
		"peeling","peeping","performing","permiting","phoning","picking","pinching","pining","placing",
		"planing","planting","playing","pleasing","plugging","pointing","poking","polishing","poping",
		"possessing","posting","pouring","practising","praying","preaching","preceding","prefering",
		"preparing","presenting","preserving","pressing","pretending","preventing","pricking","printing",
		"producing","programming","promising","protecting","providing","pulling","pumping","punching","puncturing",
		"punishing","pushing","questioning","queuing","racing","radiating","raining","raising","reaching","realising",
		"receiving","recognising","recording","reducing","reflecting","refusing","regretting","reigning","rejecting","rejoicing","relaxing","releasing","relying","remaining","remembering","reminding","removing","repairing","repeating","replacing","replying","reporting","reproducing","requesting","rescuing","retiring","returning","rhyming","rinsing","risking","robing","rocking","rolling","roting","rubing","ruining","ruling","rushing","sacking","sailing","satisfying","saving","sawing","scaring","scattering","scolding","scorching","scrapping","scratching","screaming","screwing","scribbling","scrubing","sealing","searching","separating","serving","settling","shading","sharing","shaving","sheltering","shivering","shocking","shopping","shruging","sighing","signing","signaling","sining","sipping","skiing","skipping","slapping","slipping","slowing","smashing","smelling","smiling","smoking","snatching","sneezing","sniffing","snoring","snowing","soaking","soothing","sounding","sparing","sparking","sparkling","spelling","spilling","spoiling","spoting","spraying","sprouting","squashing","squeaking","squealing","squeezing","staining","stampping","staring","starting","staying","steering","stepping","stiring","stitching","stopping","storing","strapping","strengthening","stretching","stripping","stroking","stuffing","subtracting","succeeding","sucking","suffering","suggesting","suiting","supplying","supporting","supposing","surprising","surrounding","suspecting","suspending","switching","talking","taming","tapping","tasting","teasing","telephoning","tempting","terrifying","testing","thanking","thawing","ticking","tickling","tiing","timing","tipping","tiring","touching","touring","towing","tracing","trading","training","transporting","trapping","traveling","treating","trembling","tricking","tripping","troting","troubling","trusting","trying","tuging","tumbling","turning","twisting","typing","undressing","unfastening","uniting","unlocking","unpacking","untidying","using","vanishing","visiting","wailing","waiting","walking","wandering","wanting","warming","warning","washing","wasting","watching","watering","waving","weighing","welcoming","whining","whipping","whirling","whispering","whistling","winking","wiping","wishing","wobbling","wondering","working","worrying","wrapping","wrecking","wrestling","wriggling","x-raying","yawning","yelling","zipping","zooming"));
	
	 List<String> Adjectives = new LinkedList<String>(Arrays.asList(
	"aback","abaft","abandoned","abashed","aberrant","abhorrent","abiding","abject","ablaze","able","abnormal","aboard","aboriginal",
		"abortive","abounding","abrasive","abrupt","absent","absorbed","absorbing","abstracted","absurd","abundant",
		"abusive","acceptable","accessible","accidental","accurate","acid","acidic","acoustic","acrid","actually",
		"ad hoc","adamant","adaptable","addicted","adhesive","adjoining","adorable","adventurous","afraid",
		"aggressive","agonizing","agreeable","ahead","ajar","alcoholic","alert","alike","alive","alleged",
		"alluring","aloof","amazing","ambiguous","ambitious","amuck","amused","amusing","ancient","angry",
		"animated","annoyed","annoying","anxious","apathetic","aquatic","aromatic","arrogant","ashamed",
		"aspiring","assorted","astonishing","attractive","auspicious","automatic","available","average",
		"awake","aware","awesome","awful","axiomatic","bad","barbarous","bashful","bawdy","beautiful",
		"befitting","belligerent","beneficial","bent","berserk","best","better","bewildered","big",
		"billowy","bite-sized","bitter","bizarre","black","black-and-white","bloody","blue","blue-eyed","blushing",
		"boiling","boorish","bored","boring","bouncy","boundless","brainy","brash","brave","brawny","breakable",
		"breezy","brief","bright","bright","broad","broken","brown","bumpy","burly","bustling","busy","cagey",
		"calculating","callous","calm","capable","capricious","careful","careless","caring","cautious","ceaseless",
		"certain","changeable","charming","cheap","cheerful","chemical","chief","childlike","chilly","chivalrous",
		"chubby","chunky","clammy","classy","clean","clear","clever","cloistered","cloudy","closed","clumsy",
		"cluttered","coherent","cold","colorful","colossal","combative","comfortable","common","complete",
		"complex","concerned","condemned","confused","conscious","cooing","cool","cooperative","coordinated",
		"courageous","cowardly","crabby","craven","crazy","creepy","crooked","crowded","cruel","cuddly",
		"cultured","cumbersome","curious","curly","curved","curvy","cut","cute","cute","cynical","daffy",
		"daily","damaged","damaging","damp","dangerous","dapper","dark","dashing","dazzling","dead",
		"deadpan","deafening","dear","debonair","decisive","decorous","deep","deeply","defeated","defective",
		"defiant","delicate","delicious","delightful","demonic","delirious","dependent","depressed",
		"deranged","descriptive","deserted","detailed","determined","devilish","didactic","different",
		"difficult","diligent","direful","dirty","disagreeable","disastrous","discreet","disgusted",
		"disgusting","disillusioned","dispensable","distinct","disturbed","divergent","dizzy","domineering",
		"doubtful","drab","draconian","dramatic","dreary","drunk","dry","dull","dusty","dusty",
		"dynamic","dysfunctional","eager","early","earsplitting","earthy","easy","eatable","economic",
		"educated","efficacious","efficient","eight","elastic","elated","elderly","electric","elegant",
		"elfin","elite","embarrassed","eminent","empty","enchanted","enchanting","encouraging",
		"endurable","energetic","enormous","entertaining","enthusiastic","envious","equable","equal",
		"erect","erratic","ethereal","evanescent","evasive","even","excellent","excited","exciting",
		"exclusive","exotic","expensive","extra-large","extra-small","exuberant","exultant","fabulous",
		"faded","faint","fair","faithful","fallacious","false","familiar","famous","fanatical","fancy",
		"fantastic","far","far-flung","fascinated","fast","fat","faulty","fearful","fearless","feeble",
		"feigned","female","fertile","festive","few","fierce","filthy","fine","finicky","first","five",
		"fixed","flagrant","flaky","flashy","flat","flawless","flimsy","flippant","flowery","fluffy",
		"fluttering","foamy","foolish","foregoing","forgetful","fortunate","four","frail","fragile",
		"frantic","free","freezing","frequent","fresh","fretful","friendly","frightened","frightening",
		"full","fumbling","functional","funny","furry","furtive","future","futuristic","fuzzy","gabby",
		"gainful","gamy","gaping","garrulous","gaudy","general","gentle","giant","giddy","gifted",
		"gigantic","glamorous","gleaming","glib","glistening","glorious","glossy","godly","good","goofy",
		"gorgeous","graceful","grandiose","grateful","gratis","gray","greasy","great","greedy",
		"green","grey","grieving","groovy","grotesque","grouchy","grubby","gruesome","grumpy","guarded",
		"guiltless","gullible","gusty","guttural","habitual","half","hallowed","halting","handsome",
		"handsomely","handy","hanging","hapless","happy","hard","hard-to-find","harmonious","harsh","hateful","heady","healthy","heartbreaking","heavenly","heavy","hellish","helpful","helpless","hesitant","hideous","high","highfalutin","high-pitched","hilarious","hissing","historical","holistic","hollow","homeless","homely","honorable","horrible","hospitable","hot","huge","hulking","humdrum","humorous","hungry","hurried","hurt","hushed","husky","hypnotic","hysterical","icky","icy","idiotic","ignorant","ill","illegal","ill-fated","ill-informed","illustrious","imaginary","immense","imminent","impartial","imperfect","impolite","important","imported","impossible","incandescent","incompetent","inconclusive","industrious","incredible","inexpensive","infamous","innate","innocent","inquisitive","insidious","instinctive","intelligent","interesting","internal","invincible","irate","irritating","itchy","jaded","jagged","jazzy","jealous","jittery","jobless","jolly","joyous","judicious","juicy","jumbled","jumpy","juvenile","kaput","keen","kind","kindhearted","kindly","knotty","knowing","knowledgeable","known","labored","lackadaisical","lacking","lame","lamentable","languid","large","last","late","laughable","lavish","lazy","lean","learned","left","legal","lethal","level","lewd","light","like","likeable","limping","literate","little","lively","lively","living","lonely","long","longing","long-term","loose","lopsided","loud","loutish","lovely","loving","low","lowly","lucky","ludicrous","lumpy","lush","luxuriant","lying","lyrical","macabre","macho","maddening","madly","magenta","magical","magnificent","majestic","makeshift","male","malicious","mammoth","maniacal","many","marked","massive","married","marvelous","material","materialistic","mature","mean","measly","meaty","medical","meek","mellow","melodic","melted","merciful","mere","messy","mighty","military","milky","mindless","miniature","minor","miscreant","misty","mixed","moaning","modern","moldy","momentous","motionless","mountainous","muddled","mundane","murky","mushy","mute","mysterious","naive","nappy","narrow","nasty","natural","naughty","nauseating","near","neat","nebulous","necessary","needless","needy","neighborly","nervous","new","next","nice","nifty","nimble","nine","nippy","noiseless","noisy","nonchalant","nondescript","nonstop","normal","nostalgic","nosy","noxious","null","numberless","numerous","nutritious","nutty","oafish","obedient","obeisant","obese","obnoxious","obscene","obsequious","observant","obsolete","obtainable","oceanic","odd","offbeat","old","old-fashioned","omniscient","one","onerous","open","opposite","optimal","orange","ordinary","organic","ossified","outgoing","outrageous","outstanding","oval","overconfident","overjoyed","overrated","overt","overwrought","painful","painstaking","pale","paltry","panicky","panoramic","parallel","parched","parsimonious","past","pastoral","pathetic","peaceful","penitent","perfect","periodic","permissible","perpetual","petite","petite","phobic","physical","picayune","pink","piquant","placid","plain","plant","plastic","plausible","pleasant","plucky","pointless","poised","polite","political","poor","possessive","possible","powerful","precious","premium","present","pretty","previous","pricey","prickly","private","probable","productive","profuse","protective","proud","psychedelic","psychotic","public","puffy","pumped","puny","purple","purring","pushy","puzzled","puzzling","quack","quaint","quarrelsome","questionable","quick","quickest","quiet","quirky","quixotic","quizzical","rabid","racial","ragged","rainy","rambunctious","rampant","rapid","rare","raspy","ratty","ready","real","rebel","receptive","recondite","red","redundant","reflective","regular","relieved","remarkable","reminiscent","repulsive","resolute","resonant","responsible","rhetorical","rich","right","righteous","rightful","rigid","ripe","ritzy","roasted","robust","romantic","roomy","rotten","rough","round","royal","ruddy","rude","rural","rustic","ruthless","sable","sad","safe","salty","same","sassy","satisfying","savory","scandalous","scarce","scared","scary","scattered","scientific","scintillating","scrawny","screeching","second","second-hand","secret","secretive","sedate","seemly","selective","selfish","separate","serious","shaggy","shaky","shallow","sharp","shiny","shivering","shocking","short","shrill","shut","shy","sick","silent","silent","silky","silly","simple","simplistic","sincere","six","skillful","skinny","sleepy","slim","slimy","slippery","sloppy","slow","small","smart","smelly","smiling","smoggy","smooth","sneaky","snobbish","snotty","soft","soggy","solid","somber","sophisticated","sordid","sore","sore","sour","sparkling","special","spectacular","spicy","spiffy","spiky","spiritual","spiteful","splendid","spooky","spotless","spotted","spotty","spurious","squalid","square","squealing","squeamish","staking","stale","standing","statuesque","steadfast","steady","steep","stereotyped","sticky","stiff","stimulating","stingy","stormy","straight","strange","striped","strong","stupendous","stupid","sturdy","subdued","subsequent","substantial","successful","succinct","sudden","sulky","super","superb","superficial","supreme","swanky","sweet","sweltering","swift","symptomatic","synonymous","taboo","tacit","tacky","talented","tall","tame","tan","tangible","tangy","tart","tasteful","tasteless","tasty","tawdry","tearful","tedious","teeny","teeny-tiny","telling","temporary","ten","tender","tense","tense","tenuous","terrible","terrific","tested","testy","thankful","therapeutic","thick","thin","thinkable","third","thirsty","thirsty","thoughtful","thoughtless","threatening","three","thundering","tidy","tight","tightfisted","tiny","tired","tiresome","toothsome","torpid","tough","towering","tranquil","trashy","tremendous","tricky","trite","troubled","truculent","true","truthful","two","typical","ubiquitous","ugliest","ugly","ultra","unable","unaccountable","unadvised","unarmed","unbecoming","unbiased","uncovered","understood","undesirable","unequal","unequaled","uneven","unhealthy","uninterested","unique","unkempt","unknown","unnatural","unruly","unsightly","unsuitable","untidy","unused","unusual","unwieldy","unwritten","upbeat","uppity","upset","uptight","used","useful","useless","utopian","utter","uttermost","vacuous","vagabond","vague","valuable","various","vast","vengeful","venomous","verdant","versed","victorious","vigorous","violent","violet","vivacious","voiceless","volatile","voracious","vulgar","wacky","waggish","waiting","wakeful","wandering","wanting","warlike","warm","wary","wasteful","watery","weak","wealthy","weary","well-groomed","well-made","well-off","well-to-do","wet","whimsical","whispering","white","whole","wholesale","wicked","wide","wide-eyed","wiggly","wild","willing","windy","wiry","wise","wistful","witty","woebegone","womanly","wonderful","wooden","woozy","workable","worried","worthless","wrathful","wretched","wrong","wry","yellow","yielding","young","youthful"));
	
	List<String> PrefixValues = new LinkedList<String>(Arrays.asList(
	     "Hot","Cold","Blazing","Burning","Freezing","Extreme","oversized","rotund","particular","mean","zistonian",
		"Canadian","american","british","Hispanic","Jewish","Irish","Scottish","Incredible","Ordinary",
		"asgard","ancient","dwarven",
		"Ethiopian","martian","turkish","vegetative","Holy","Orcish"));
	
	
	
	public List<String> Hoe = new LinkedList<String>(Arrays.asList( "Hoe","Till","Trowel"));
		public List<String> Shovel = new LinkedList<String>(Arrays.asList("Shovel","Digger"));
	
	private HardcoreMobs _Owner = null;
	public HardcoreMobs getOwner() { return _Owner;}
	public void setOwner(HardcoreMobs value){ _Owner=value;}
	public NameGenerator(HardcoreMobs bcRandomizer) {
			// TODO Auto-generated constructor stub
		_Owner = bcRandomizer;
		readData();
	
		
		}
	
	private void readData(){
		//
		String GenINI = _Owner.pluginMainDir + NameGenerator.GeneratorINI;
		//if the file exists, open it.
		File wordsfile = new File(GenINI);
		if(wordsfile.exists()){
			
			//read it in as an INIFile.
			try {
				Scanner sc = new Scanner(wordsfile);
				//read in each line.
				String currentline=null;
				//we'll use a indexed lookup for the entries.
				TreeMap<String,List<String>> listlookup = new TreeMap<String,List<String>>(String.CASE_INSENSITIVE_ORDER);
				
				listlookup.put("NOUN", this.Nouns);
				listlookup.put("VERB", this.Verbs);
				listlookup.put("ADJECTIVE", this.Adjectives);
				listlookup.put("SWORD", this.Sword);
				listlookup.put("HELMET", this.Hats);
				listlookup.put("CHESTPLATE", this.Chestplates);
				listlookup.put("LEGGINGS", this.Pants);
				listlookup.put("BOOTS", this.Boots);
				listlookup.put("BOW",this.Bow);
				listlookup.put("PICKAXE", this.Pickaxe);
				listlookup.put("SHOVEL", this.Shovel);
				listlookup.put("HOE", this.Hoe);
				listlookup.put("AXE", this.Axe);
				listlookup.put("MOBNAME", this.MobNames);
				listlookup.put("MOBTITLE", this.MobTitles);
				int wordsadded = 0;
				while(sc.hasNextLine() && (null!=(currentline=sc.nextLine()))){
					//parse it. First, split at equals.
					//check for a comment.
					currentline=currentline.trim();
					if(!currentline.startsWith("//") &&
							currentline.contains("=")){
						//make sure it isn't a comment, and that it contains
						//an equals sign.
						//split at equals sign.
						String[] splitresult = currentline.split("=");
						//only continue of listlookup contains the first array element
						//as a key.
						if(listlookup.containsKey(splitresult[0])){
							
							//split the second parameter at commas.
							String[] splitaddwords = splitresult[1].split(",");
							for(String iterate:splitaddwords){
								if(iterate.equalsIgnoreCase("!clear!")){
								listlookup.get(splitresult[0]).clear();	
									
								}else {
								listlookup.get(splitresult[0]).add(iterate.trim());
								
								wordsadded++;
								}
							}
							
							
							
							
							
						}
						
						
						
					}
					
					
					
					
				}
				HardcoreMobs.emitmessage("added " + wordsadded + " words from " + GenINI);
				
			}
				
				
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public String RandomMobName(String mobType){
		//MobNames of MobTitles 
		//or MobNames of Adjective Noun
		StringBuffer sb = new StringBuffer();
		if(mobType.length()>0) sb.append(mobType);
		if(RandomData.rgen.nextBoolean()){
			//MobNames of MobTitles
			sb.append(RandomData.ChooseString(MobNames));
			sb.append(" of ");
			sb.append(RandomData.ChooseString(MobTitles));
			
		}
		else
		{
			sb.append(RandomData.ChooseString(MobNames));
			sb.append(" of ");
			sb.append(RandomData.ChooseString(Verbs));
			sb.append(" ");
			sb.append(RandomData.ChooseString(Nouns));
			
		}
		

		return sb.toString();
		
		
	}
	public String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder();
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        }
	        	
	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}
	public String GenerateName(String[] FormatStrings,Hashtable<String,List<String>> Mappings){
		String chosen = RandomData.Choose(FormatStrings);
		return GenerateName(chosen,Mappings);
		
		
	}
	//added: special routine to create a nonsense phrase. 
	
	public String GenerateName(String FormatString,Hashtable<String,List<String>> Mappings){
	
		//iterate through all keys in the hashtable.
		//with each key, find each instance of {key} in the FormatString. replace it with a random item chosen from the 
		//List indexed at that Key. repeat, return the result.
		String duplicated = FormatString;
		for(String keyloop:Mappings.keySet()){
			String[] selectfrom=null;
			selectfrom = Mappings.get(keyloop).toArray(selectfrom);
			String searchfor = "{" + keyloop + "}";
			//iterate while we can find it.
			int foundlocation=1;
			while((foundlocation=duplicated.indexOf(searchfor)) > -1){
				
				//we found it at foundlocation. now choose a random element from the List...
				String chosenelement = RandomData.Choose(selectfrom);
				duplicated = duplicated.substring(0,foundlocation) + chosenelement + duplicated.substring(foundlocation+searchfor.length());
				
				
				
			}
			
			
			
		}
		
		
		return duplicated;
		
	}
	private ChatColor[] chooseColors = new ChatColor[] {ChatColor.AQUA,ChatColor.BLUE,ChatColor.DARK_AQUA,
			ChatColor.DARK_BLUE,ChatColor.DARK_GRAY,ChatColor.DARK_GREEN,ChatColor.DARK_PURPLE,
			ChatColor.DARK_RED,ChatColor.GOLD,ChatColor.GREEN,ChatColor.LIGHT_PURPLE,ChatColor.WHITE,ChatColor.YELLOW};
	
	private ChatColor[] chooseEffects = new ChatColor[] {ChatColor.ITALIC,ChatColor.UNDERLINE};
	
	private String ChooseRandomChat(){
		
		
		//choose a random color.
		String returnString = RandomData.Choose(chooseColors).toString();
		//choose one or two effects.
		int numeffects = RandomData.rgen.nextBoolean()?1:2;
		for(int i=0;i<numeffects;i++){
			ChatColor choseneffect = RandomData.Choose(chooseEffects);
			returnString = returnString + choseneffect.toString();
			
			
			
		}
		return returnString;
		
		
		
	}
	public String GenerateLore() {
		try {
		String[] ChancePrefix = new String[] {
				"Could","Might","Unlikely to","able to","may adeptly","may sadly","may happily","may", "will", "wants to",
				"May force the"};
		String[] conjunctionp = new String[] {
		"incur","cause","destroy","tickle","beat","defeat","suffer","argue"};
		String[] randommiddle = new String[] {
		"the wrath of","the pestilence of","the","all sorts of","most kinds of","for not many","take exception to"};
		
		
		StringBuffer buildstr = new StringBuffer();
		buildstr.append(RandomData.Choose(ChancePrefix) + " ");
		buildstr.append(RandomData.Choose(conjunctionp) + " ");
		buildstr.append(RandomData.Choose(randommiddle) + "\n");
		buildstr.append(RandomData.ChooseString(PrefixValues) + " ");
		buildstr.append(RandomData.ChooseString(Verbs) + " ");
		buildstr.append(RandomData.ChooseString(Nouns) + " ");
		
		//select a random chat color, and put it in with new lines.
		String loreeffect = ChooseRandomChat();
				return buildstr.toString().replace("\n","\n"+loreeffect);
		
		}
		catch(Exception exx){
			return "";
		}
		
				
				
		
		
		
	}
				
		
	public String GenerateName(List<String> BaseNames,List<String> Adjectives,List<String> Verbs){
		if(Verbs==null) Verbs = new LinkedList<String>();
		String[] bname = new String[BaseNames.size()];
		String[] adj = new String[Adjectives.size()];
		String[] verb = new String[Verbs.size()];
		BaseNames.toArray(bname);
		Adjectives.toArray(adj);
		Verbs.toArray(verb);
		return ChooseRandomChat() + GenerateName(bname,adj,verb);
		
		
	}
		
	
	public String GenerateName(String[] BaseNames,String[] Adjectives,String[] Verbs){
	
		
		StringBuffer sb = new StringBuffer();
		//first array is base name; eg, "Sword, Blade, Slicer, Katana, etc.
		//second array is adjectives; "imminent","bloody","extreme","metallic","superlative","powerful","thirstful","vengeful","smelly","stinky","immaculate","particular"
		//third array is verbs; bloodening,cutting,slicing,revenge
		
		
		String prefix = "";
		if(RandomData.rgen.nextFloat() > 0.75){
			prefix = RandomData.ChooseString(PrefixValues);
			
		}
		if(prefix.length()>0) prefix = prefix + " ";
		String basename = RandomData.Choose(BaseNames);
		
		
		String adjective = RandomData.rgen.nextFloat()>0.5?RandomData.Choose(Adjectives):"";
		String Verb = RandomData.Choose(Verbs);
		
		sb.append(prefix);
		sb.append(basename);
		if(adjective!=""){
			sb.append(" of " + adjective + " " + Verb);
			
		}
		
		return toTitleCase(sb.toString());
		
		
	}
	
	
}
