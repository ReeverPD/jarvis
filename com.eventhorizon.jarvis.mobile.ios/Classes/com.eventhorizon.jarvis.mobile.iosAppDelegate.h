//
//  com.eventhorizon.jarvis.mobile.iosAppDelegate.h
//  com.eventhorizon.jarvis.mobile.ios
//
//  Created by _developer_ on 12.12.10.
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class com.eventhorizon.jarvis.mobile.iosViewController;

@interface com.eventhorizon.jarvis.mobile.iosAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    com.eventhorizon.jarvis.mobile.iosViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet com.eventhorizon.jarvis.mobile.iosViewController *viewController;

@end

