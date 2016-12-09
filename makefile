
JC = javac

WIDGET = Widget/*.java
MAIN = Main/*.java
TOOLSIMG = ToolsImg/*.java
SOBEL = Sobel/Sobel.java

widget :
	$(JC) $(WIDGET)

main :
	$(JC) $(MAIN)

toolsimg :
	$(JC) $(TOOLSIMG)

sobel :
	$(JC) $(SOBEL)

all: all_normal
	jar cmf META-INF/MANIFEST.MF AppSobel.jar */*.class
	touch run
	echo "java -jar AppSobel.jar">run
	chmod +x run
	echo "Pour démarer le programme utiliser la commande ./run"

all_normal: main widget toolsimg sobel

doc :
	javadoc -d ./DOC Main ToolsImg Sobel Widget

clean :
	rm -f */*.class
	rm -f run
	rm -f AppSobel.jar

clean_doc :
	rm -rf ./DOC/*

clean_all : clean clean_doc
