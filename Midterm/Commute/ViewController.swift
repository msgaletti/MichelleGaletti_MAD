//
//  ViewController.swift
//  Commute
//
//  Created by Michelle Galetti on 10/15/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var milesAmount: UITextField!
    @IBOutlet weak var commuteTime: UILabel!
    @IBOutlet weak var gasNeeded: UILabel!
    @IBOutlet weak var gasTankAmount: UILabel!
    @IBOutlet weak var typeMode: UISegmentedControl!
    @IBOutlet weak var transImage: UIImageView!
    @IBOutlet weak var mileSlider: UISlider!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        milesAmount.delegate = self
        // Do any additional setup after loading the view.
    }
    @IBAction func calculateCommute(_ sender: Any) {
        updateCommute()
    }
    
    func updateCommute(){
        var miles:Float
        if milesAmount.text!.isEmpty {
            miles = 0.0
        } else {
            miles = Float(milesAmount.text!)!
        }
        let time = Float(((1/miles)*20)*60)
        let gas = Float((1/24)*miles)
        
        let mileFormatter = NumberFormatter()
        mileFormatter.numberStyle=NumberFormatter.Style.decimal //set the number style
        commuteTime.text=mileFormatter.string(from: NSNumber(value: time)) //returns a formatted string
        gasNeeded.text=mileFormatter.string(from: NSNumber(value: gas))
    }
    @IBAction func gallonAmount(_ sender: UISlider) {
        let gallonSize=sender.value //float
        gasTankAmount.text=String(format: "%.0f", gallonSize) //convert float to String
    }
    func updateTime(){
        var mileMonth: Float
        if milesAmount.text!.isEmpty {
            mileMonth = 0.0
        } else {
            mileMonth = Float(milesAmount.text!)!
        }
        let totalTime = Float((((1/mileMonth)*20)*60)*20)
        let totalGas = Float(((1/24)*mileMonth)*20)
        
        let mileFormatter = NumberFormatter()
        mileFormatter.numberStyle=NumberFormatter.Style.decimal //set the number style
        commuteTime.text=mileFormatter.string(from: NSNumber(value: totalTime)) //returns a formatted string
        gasNeeded.text=mileFormatter.string(from: NSNumber(value: totalGas))
        
    }
    
    @IBAction func updateMonthly(_ sender: UISwitch) {
        updateTime()
    }
    
    func updateMode(){
        if typeMode.selectedSegmentIndex == 0 {
                let alert=UIAlertController(title: "Suggestion", message: "Consider carpooling to reduce Carbon Footprint", preferredStyle: UIAlertController.Style.alert)
                //create a UIAlertAction object for the button
                let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction) //adds the alert action to the alert object
                let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                    self.updateCommute()
                })
                alert.addAction(okAction)
                present(alert, animated: true, completion: nil)
            //end else
            updateCommute()
            transImage.image=UIImage(named: "car_icon")
            
        }
        else if typeMode.selectedSegmentIndex == 1 {
            var mileBus:Float
            if milesAmount.text!.isEmpty {
                mileBus = 0.0
            } else {
                mileBus = Float(milesAmount.text!)!
            }
            let timeBus = Float((((1/mileBus)*12)*60)+5)
            let gasBus = Float(0.0)
            
            let mileFormatter = NumberFormatter()
            mileFormatter.numberStyle=NumberFormatter.Style.decimal //set the number style
            commuteTime.text=mileFormatter.string(from: NSNumber(value: timeBus)) //returns a formatted string
            gasNeeded.text=mileFormatter.string(from: NSNumber(value: gasBus))
            transImage.image=UIImage(named: "bus_icon")
        }
        else if typeMode.selectedSegmentIndex == 2{
            var mileBike:Float
            if milesAmount.text!.isEmpty {
                mileBike = 0.0
            } else {
                mileBike = Float(milesAmount.text!)!
            }
            let timeBike = Float(((1/mileBike)*10)*60)
            let gasBike = Float(0.0)
            
            let mileFormatter = NumberFormatter()
            mileFormatter.numberStyle=NumberFormatter.Style.decimal //set the number style
            commuteTime.text=mileFormatter.string(from: NSNumber(value: timeBike)) //returns a formatted string
            gasNeeded.text=mileFormatter.string(from: NSNumber(value: gasBike))
            transImage.image=UIImage(named: "bike_icon")
        }
    }
    
    @IBAction func changeMode(_ sender: UISegmentedControl) {
        updateMode()
    }
    
}

