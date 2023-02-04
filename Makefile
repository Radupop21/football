build:
	javac *.java
run:
	java Main $(COMANDA) $(IN1) $(IN2) > $(OUT)
clean:
	rm -f *.class
	rm -f *.css
	rm -f *.html