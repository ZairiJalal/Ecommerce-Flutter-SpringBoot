import { StatusBar } from 'expo-status-bar';
import React, { Component } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import 'react-native-gesture-handler'; 
import { NavigationContainer } from '@react-navigation/native'; 
import { createStackNavigator } from '@react-navigation/stack'; 
import PageDeRecherche from './PageDeRecherche'; 
import ResultatsDeRecherche from './ResultatsDeRecherche'; 

const Pile = createStackNavigator();

function MaPile() { 
 return ( 
 <Pile.Navigator> 
 <Pile.Screen name="Accueil" component={PageDeRecherche} />
 <Pile.Screen name="Resultats" component={ResultatsDeRecherche} /> 
 </Pile.Navigator> 
 ); 
} 
export default class App extends Component { 
 
render() 
 { 
return ( 
<React.StrictMode> 
<NavigationContainer> 
<MaPile />
</NavigationContainer> 
</React.StrictMode>
 ); 
 } 
} 

const styles = StyleSheet.create({ 
  description: { 
  fontSize: 18, 
  textAlign: 'center', 
  color: '#656565', 
  marginTop: 65, 
  }, 
 });
