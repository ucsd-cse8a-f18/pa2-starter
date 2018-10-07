// To test, before running, do "python -m SimpleHTTPServer" from this directory
// URL params don't work from file:/// urls; this is an easy way to start a
// local server


// Browser opening code courtesy of
// https://stackoverflow.com/a/17950164/2718315
import java.awt.Desktop;
import java.net.URI;

int getZoom() { return zoom; }


String getCSELat() { return CSELat; }
String getCSELong() { return CSELong; }
String getCSELabel() { return CSELabel; }

String getDestLat() { return destLat; }
String getDestLong() { return destLong; }
String getDestLabel() { return destLabel; }

boolean showCSE = false;
if(getCSELat() != null &&
   getCSELong() != null) {
  showCSE = true;
}

boolean showDest = false;
if(getDestLat() != null &&
   getDestLong() != null) {
  showDest = true;
}

int zoomMap = 2;
if (showCSE) {
  if (getZoom() != 0) { zoomMap = getZoom(); }
  else { zoomMap = 5;}
}
if (showDest) {
  zoomMap = getZoom();
}

String label = getDestLabel();
if(label == null) { label = "no-label-yet"; }


String URLCSELat = getCSELat();
String URLCSELong = getCSELong();

String URLDestLat = getDestLat();
String URLDestLong = getDestLong();

// https://stackoverflow.com/questions/724043/http-url-address-encoding-in-java
URI url = new URI(
  "https",
  "cseweb.ucsd.edu",
  "/classes/fa18/cse8a/maps.html",
  "latA=" + URLCSELat + "&" +
  "longA=" + URLCSELong + "&" +
  "latB=" + URLDestLat + "&" +
  "longB=" + URLDestLong + "&" +
  "label=" + label + "&" +
  "zoom=" + zoomMap + "&" +
  "showCSE=" + showCSE + "&" +
  "showDest=" + showDest,
  null);

System.out.println(url.toString());

if (Desktop.isDesktopSupported()) {
  Desktop.getDesktop().browse(url);
} else {
  System.out.println("Your system may not be supported, try running on the lab machines, or copy/paste this URL into your browser: \n" + url);
}
