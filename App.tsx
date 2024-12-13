import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  TextInput,
  Button,
  View,
ScrollView
} from 'react-native';

import NativeLocalStorage from './specs/NativeLocalStorage';
import { WebView } from 'react-native-webview';
import processUrl from './utils/processUrl';

const EMPTY = '<empty>';

function App(): React.JSX.Element {
  const [value, setValue] = React.useState<string | null>(null);
  const [accessToken, setAccessToken] = React.useState('');
  const handleNavigationChange = (navState) => {
    if(navState?.url.includes('access_token=')){
      let extractedAccessToken = processUrl(navState.url)
      setAccessToken(extractedAccessToken);
    }
    
    console.log('Navigated to URL:', navState.url);
  };
  const [editingValue, setEditingValue] = React.useState<
    string | null
  >(null);



  return (
     <ScrollView      contentInsetAdjustmentBehavior="automatic"
      style={styles.scrollView}
    >
    
      <View style={styles.container}>
        <WebView
          style={styles.webView}
          textZoom={100}
          source={{ uri: 'https://git.corp.adobe.com/pages/IMS/imslib2.js/demo-react-app/' }}
          javaScriptEnabled={true}
          javaScriptEnabledAndroid={true}
          originWhitelist={['*']}
          domStorageEnabled={true}
          mixedContentMode="always"
          onReceivedSslError={(event) => {
            console.warn("SSL error ignored for development purposes.");
            event.proceed();
          }}
          onError={(syntheticEvent) => {
            const { nativeEvent } = syntheticEvent;
            console.error('WebView error: ', nativeEvent.description || nativeEvent.code);
          }}
        
          onMessage={(event) => {
            console.log('Session Storage:', event.nativeEvent.data);
          }}
          onNavigationStateChange={handleNavigationChange} // Log URL changes
        />
      </View>
      <Text>
        {accessToken}
      </Text>
      <Button title="open custom view with message " onPress={()=>{NativeLocalStorage?.openCustomScreen("naman")}} />
    

    </ScrollView>

  );
}

const styles = StyleSheet.create({
  text: {
    margin: 10,
    fontSize: 20,
  },
  textInput: {
    margin: 10,
    height: 40,
    borderColor: 'black',
    borderWidth: 1,
    paddingLeft: 5,
    paddingRight: 5,
    borderRadius: 5,
  },
  scrollView: {
    flex: 1,
    backgroundColor: '#f5f5f5', // Optional: Background color
  },
  container: {
    flex: 1,
    height: 800, // Set a height to ensure scrollability if content overflows
  },
  webView: {
    flex: 1,
    height: 800, // Ensure WebView is scrollable within the View
  },
});

export default App;