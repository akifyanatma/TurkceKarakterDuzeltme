import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class GUI {

	private JFrame frmTrkeKarakterDzeltme;
	
	public Google_Search mGoogle_Search;
	public Potential mPotential;
	List<String> mPotentialList;
	List<String> mContents;
	public ArrayList<Integer> mCounters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
					window.frmTrkeKarakterDzeltme.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
		mPotential = new Potential();
		mPotentialList = new ArrayList<String>();
		mGoogle_Search = new Google_Search();
		mContents = new ArrayList<String>();
		mCounters = new ArrayList<Integer>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrkeKarakterDzeltme = new JFrame();
		frmTrkeKarakterDzeltme.setTitle("T\u00FCrk\u00E7e Karakter D\u00FCzeltme");
		frmTrkeKarakterDzeltme.setBounds(100, 100, 741, 734);
		frmTrkeKarakterDzeltme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrkeKarakterDzeltme.getContentPane().setLayout(null);
		
		JLabel lbl_Correct = new JLabel("D\u00FCzg\u00FCn Metin:");
		lbl_Correct.setBounds(150, 25, 84, 14);
		frmTrkeKarakterDzeltme.getContentPane().add(lbl_Correct);
		
		JLabel lbl_WordCount = new JLabel("Kelime Say\u0131s\u0131:");
		lbl_WordCount.setBounds(143, 49, 107, 23);
		frmTrkeKarakterDzeltme.getContentPane().add(lbl_WordCount);
		
		JLabel lbl_Faulty = new JLabel("Bozuk Metin:");
		lbl_Faulty.setBounds(166, 223, 84, 14);
		frmTrkeKarakterDzeltme.getContentPane().add(lbl_Faulty);
		
		JLabel lbl_Edited = new JLabel("D\u00FCzeltilmi\u015F Metin:");
		lbl_Edited.setBounds(148, 441, 102, 23);
		frmTrkeKarakterDzeltme.getContentPane().add(lbl_Edited);
		
		JLabel lblResult = new JLabel("Sonu\u00E7: ");
		lblResult.setBounds(199, 634, 342, 23);
		frmTrkeKarakterDzeltme.getContentPane().add(lblResult);
		
		JTextArea textArea_Correct = new JTextArea();
		textArea_Correct.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) 
			{
				String correctText = textArea_Correct.getText();
				String[] words = correctText.split(" ");
				int wordCount = words.length;
				if(correctText.length() == 0)
					lbl_WordCount.setText("Kelime Sayýsý: "+0);	
				else
					lbl_WordCount.setText("Kelime Sayýsý: "+wordCount);
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				String correctText = textArea_Correct.getText();
				String[] words = correctText.split(" ");
				int wordCount = words.length;
				if(correctText.length() == 0)
					lbl_WordCount.setText("Kelime Sayýsý: "+0);	
				else
					lbl_WordCount.setText("Kelime Sayýsý: "+wordCount);
			}
		});

		textArea_Correct.setWrapStyleWord(true);
		textArea_Correct.setLineWrap(true);
		textArea_Correct.setBounds(274, 25, 441, 177);
		frmTrkeKarakterDzeltme.getContentPane().add(textArea_Correct);
		
		JTextArea textArea_Faulty = new JTextArea();
		textArea_Faulty.setWrapStyleWord(true);
		textArea_Faulty.setLineWrap(true);
		textArea_Faulty.setBounds(274, 223, 441, 185);
		frmTrkeKarakterDzeltme.getContentPane().add(textArea_Faulty);
		
		JTextArea textArea_Edited = new JTextArea();
		textArea_Edited.setWrapStyleWord(true);
		textArea_Edited.setLineWrap(true);
		textArea_Edited.setBounds(274, 432, 441, 191);
		frmTrkeKarakterDzeltme.getContentPane().add(textArea_Edited);
		
		JButton btn_Latin = new JButton("T\u00FCrk\u00E7e Karakterleri D\u00F6n\u00FC\u015Ft\u00FCr");
		btn_Latin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			//Latin alfabesine çevirme iþlemi
			String faultyText = textArea_Correct.getText();
			String latinText = faultyText;
			latinText = latinText.replace("ç", "c");
			latinText = latinText.replace("Ç", "C");
			latinText = latinText.replace("ð", "g");
			latinText = latinText.replace("Ð", "G");
			latinText = latinText.replace("ý", "i");
			latinText = latinText.replace("Ý", "I");
			latinText = latinText.replace("ö", "o");
			latinText = latinText.replace("Ö", "O");
			latinText = latinText.replace("þ", "s");
			latinText = latinText.replace("Þ", "S");
			latinText = latinText.replace("ü", "u");
			latinText = latinText.replace("Ü", "U");
			
			textArea_Faulty.setText(latinText);
			lblResult.setText("Sonuç:");
			
		}
		});
		btn_Latin.setBounds(60, 83, 204, 23);
		frmTrkeKarakterDzeltme.getContentPane().add(btn_Latin);
	

		
		JButton btn_Turkish = new JButton("T\u00FCrk\u00E7e Karakterleri Ekle");
		btn_Turkish.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			//Turkçeye cevirme iþlemi
			String latinText = textArea_Faulty.getText();
			try {
				editText(latinText, textArea_Edited, textArea_Correct, lblResult);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
		btn_Turkish.setBounds(75, 248, 189, 23);
		frmTrkeKarakterDzeltme.getContentPane().add(btn_Turkish);
		
	}
	
	private void editText(String pLatinText, JTextArea pTextArea_Edited, JTextArea pTextArea_Correct, JLabel pLabelResult) throws Exception
	{ 
		String[] words = pLatinText.split(" ");
		
		String searchingString = "";
		
		for(int i=0; i<words.length; i++)
		{				
			if(words.length == 1)//Tum text tek kelimeden oluþuyorsa
			{
				searchingString = words[0];
			}
			else if(i == (words.length-1)) // Ele alinan kelime son kelime ise
			{
				if(isContainPunctuator(words[i-1]) == false)
				{
					searchingString = words[i-1] +" "+words[i];
				}
				else
				{
					searchingString = words[i];
				}
			}
			else // Tüm kelime sayisinin 1 oldugu durum ve son kelime haricindeki ele alinan kelimeler
			{
				if(isContainPunctuator(words[i]) == false)
				{
					searchingString = words[i] +" "+words[i+1];
				}
				else if(i!=0 && isContainPunctuator(words[i-1]) == false)
				{
					searchingString = words[i-1] +" "+words[i];
				}
				else
				{
					searchingString = words[i];
				}
			}


			String handlingWord = words[i];			
			System.out.println("HandlingWord: "+handlingWord);
			
			if(isEditNecessary(handlingWord)) //Sözcük içerisinde "c,C,g,G,i,I,o,O,s,S,u,U" karakterlerinden birini içermiyorsa kontrol etmeye gerek yoktur cunku zaten duzgundur.
			{
				createPotentials(handlingWord);
				
				while(isContainPunctuator(searchingString) && searchingString.length()!=1)
					searchingString = removeLastChar(searchingString);
							
				System.out.println("Aranacak string:"+searchingString);
				searchInGoogle(searchingString.toLowerCase());
				String correctString = findCorrectString();
				words[i] = correctString;
			}

			pTextArea_Edited.append(words[i]+" ");	
		}
		
		calculateResult(pTextArea_Edited, pTextArea_Correct, pLabelResult);
	}
	
	//Sözcük içerisinde "c,C,g,G,i,I,o,O,s,S,u,U" karakterlerinden birini içermiyorsa kontrol etmeye gerek yoktur cunku zaten duzgundur.
	private boolean isEditNecessary(String pHandlingString)
	{
		boolean isNecessary = true;
		
		if(pHandlingString.indexOf("c")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("C")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("g")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("G")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("i")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("I")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("o")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("O")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("s")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("S")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("u")!=-1)
			isNecessary = true;
		else if(pHandlingString.indexOf("U")!=-1)
			isNecessary = true;
		else
			isNecessary = false;
		
		return isNecessary;											
	}
	
	private void calculateResult(JTextArea pTextArea_Edited, JTextArea pTextArea_Correct, JLabel pLabelResult)
	{
		String result;
		String[] pCorrectWords = pTextArea_Correct.getText().split(" ");
		String editedWords[] = pTextArea_Edited.getText().split(" ");
		
		int difference = 0;
		if(pCorrectWords.length == editedWords.length)
		{
			for(int i=0; i<pCorrectWords.length; i++)
			{
				if(pCorrectWords[i].compareTo(editedWords[i])!=0)
					difference++;
			}
			
			result = "Sonuç: "+(pCorrectWords.length-difference)+"/"+(pCorrectWords.length)+",    Baþarým yüzdesi:  %"+((double)(pCorrectWords.length-difference)/(double)(pCorrectWords.length))*100;
		}
		else
		{
			result = "Sonuç: Baþarým oraný hesaplanamadý.";
		}
		
		pLabelResult.setText(result);
	}
	
	private String removeLastChar(String str) 
	{
        return str.substring(0,str.length()-1);
    }
	
	private String findCorrectString()
	{
		mCounters.clear();
		
		for(int i=0; i<mPotentialList.size();i++)
		{
			int count = 0;
			String compareString = mPotentialList.get(i);
			compareString = compareString.toLowerCase();
			
			while(isContainPunctuator(compareString) && compareString.length() != 1)
				compareString = removeLastChar(compareString);
			
			for(int j=0; j<mContents.size(); j++)
			{   
				count += countSubstring(compareString, mContents.get(j));
			}
			
			System.out.println("Kelime:"+compareString+" count:"+" "+count);
			mCounters.add(count);
		}
		
		int max = 0;
		int index = 0;
		for(int k=0; k<mCounters.size();k++)
		{
			if(mCounters.get(k)>max)
			{
				max = mCounters.get(k);
				index = k;
			}
		}
				
		return mPotentialList.get(index);
	}
			
	private int countSubstring(String subStr, String str)
	{
		int count = (str.length() - str.replace(subStr, "").length()) / subStr.length();
		System.out.println("Count in countSubstring: "+count);
		return count;
	}
	
	private void createPotentials(String pString)
	{
		mPotentialList.clear();
		mPotentialList = mPotential.createPotentials(pString);
	}
	
	private void searchInGoogle(String pSearchingString) throws Exception
	{	
		System.out.println("searchInGoogle("+pSearchingString+") functioun is called");
		mContents.clear();
		
		while(mContents.size() == 0)
		{
			System.out.println(pSearchingString + " is searching..");
			mContents = mGoogle_Search.GetGoogleResults(pSearchingString);
		}
		if(mContents.size()==0)
			System.out.println("mContents listesi BOS");
		for(int i=0;i<mContents.size();i++)
		{
			System.out.println(mContents.get(i)+"\n");
		}
	}
	
	private boolean isContainPunctuator(String pWord)
	{
		boolean isContain = false;
		
		if(pWord.contains(".") || pWord.contains(",") || pWord.contains("?") || pWord.contains("!") || pWord.contains(":") || pWord.contains(";") || pWord.contains("...") || pWord.contains("\""))
		{
			isContain = true;
		}
		
		return isContain;	
	}
}
