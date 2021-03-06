package org.hsbo.gierthhensen.bewegungstrackerduisburg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Lukas Gierth and Matthias Hensen
 * FragmentClass for a map fragment
 * Shows a webview containing the index.html (which loads leaflet).
 */
public class MapFragment extends Fragment {

    WebView webView;
    View view;

    /**
     * Required empty constructor.
     */
    public MapFragment() {
    }

    /**
     * Creates a new instance of MapFragment.
     * @return frg
     */
    public static Fragment newInstance() {
        MapFragment frg = new MapFragment();
        return frg;
    }

    /**
     * Called when a fragment gets created.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called on first creation of the fragment.
     * Connects WebView and WebView settings.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_map, container, false);
        webView = (WebView) view.findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);

        webView.loadUrl("file:///android_asset/index.html");

        return view;
    }
}
