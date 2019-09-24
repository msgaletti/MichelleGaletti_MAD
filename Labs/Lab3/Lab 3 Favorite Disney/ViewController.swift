//
//  ViewController.swift
//  Lab 3 Favorite Disney
//
//  Created by Michelle Galetti on 9/20/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var disneyTitle: UILabel!
    @IBOutlet weak var changeShow: UISegmentedControl!
    @IBOutlet weak var captionTv: UILabel!
    @IBOutlet weak var imageChange: UIImageView!
    @IBOutlet weak var capsSwitch: UISwitch!
    @IBOutlet weak var fontLabel: UILabel!
    @IBOutlet weak var capitalLabel: UILabel!
    
    func updateDisney(){
        if changeShow.selectedSegmentIndex == 0 {
            captionTv.text="Call me, beep me, if you wanna reach me!"
            captionTv.textColor=UIColor(red: 0.0745, green: 0.2667, blue: 0, alpha: 1.0)
            imageChange.image=UIImage(named: "kimpossible")
        }
        else if changeShow.selectedSegmentIndex == 1 {
            captionTv.text="I can see into the future!"
            captionTv.textColor = UIColor.purple
            imageChange.image=UIImage(named: "raven")
        }
        else if changeShow.selectedSegmentIndex == 2{
            captionTv.text = "Who lives in a pineapple under the sea?"
            captionTv.textColor = UIColor.brown
            
            imageChange.image=UIImage(named: "sponge")
        }
        else if changeShow.selectedSegmentIndex == 3{
            captionTv.text = "Yes we have a suite life!"
            captionTv.textColor=UIColor.blue
            
            imageChange.image=UIImage(named:"suite")
        }
    }
    
    func upperCaps(){
        if capsSwitch.isOn {
            captionTv.text=captionTv.text?.uppercased()
        } else {
            captionTv.text=captionTv.text?.lowercased()
        }
    }
    
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateDisney()
        upperCaps()
    }
    
    @IBAction func updateCaps(_ sender: UISwitch) {
        upperCaps()
    }
    

    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize=sender.value //float
        
        fontLabel.text=String(format: "%.0f", fontSize) //convert float to String
        let fontSizeCGFloat=CGFloat(fontSize) //convert float to CGFloat
        disneyTitle.font=UIFont.systemFont(ofSize: fontSizeCGFloat) //create a UIFont object and assign to the font property
    }

    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

