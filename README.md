![magmanium logo](https://github.com/FoxInASombrero/magmanium/blob/master/magmanium_logo.png?raw=true)

# magmanium (MC 1.4.7)

A Magma Block az egyik legkirályabb block, igazam van?  
Szerintem igen, éppen ezért úgy gondoltam, hogy visszaportolom Minecraft 1.4.7-re!  

## Mit kínál a mod?

Nos, kb. azt, amit leírtam. Ez egy Magma Block backport mod, ami így... működik...  
Ez egy hobbi projekt és sok esetben előfordulhat, hogy hibás a mod, de igyekszem javítani.  

## Van tervben esetleg más verzióra való portolás is?

Van! Bár eléggé idő szűkében vagyok (ezért is nincs még release), de már több verzióra is megvan a sablon, csak tesztelni kellene.  
Tervben van a toolchain által elérhető összes verzióra való kiadás, ám, hogy ebből mi valósul meg, azt csak az idő tudja megmondani.  
Emellett, ahogy időm és kedvem engedi, tervezek még más, kisebb modokat is kiadni, amik szintén 1-2 dolgot backportolnak.

## Technikai nehézségek

A mod portolása során az egyik legnagyobb nehézséget az jelentette, hogy a netherben való érc generálás csak 1.5.2-ben jelent meg, ezért szükség volt a kód módosítására.  
Ezt megtettem, létrehoztam egy egyedi WorldGenMineable-t, ami képes a netherben is érceket generálni. __Juhéj__! 🎉  

A másik nehézség ennél is érdekesebb.  
Gondolom, hogy nem kell mondanom, hogy a Minecraft 1.4.7 egy öreg verzió. De úgy nagyon. 
A mod készítésének évének őszén ünnepelte 11. születésnapját. (hu, de szép mondat volt ez... mindegy, 2023)  
Azért az valljuk be, nem most volt... Ennek köszönhetően a Minecraft Forge toolchain-ek bizony mára már többé-kevésbé használhatatlanná váltak...  
... legalább is azt hittem, amíg rá nem találtam a [voldeloom](https://github.com/CrackedPolishedBlackstoneBricksMC/voldeloom)-ra, ami teljesen felforgatott mindent.  
Ez a toolchain lehetővé teszi azt, hogy ősrégi Minecraft verziókra modern külsőben lehessen modokat fejleszteni, ami egyszerűen __mindblowing__!  

Ebből következik, hogy a mod teljes egészében __voldeloom__ segítségével készült!

