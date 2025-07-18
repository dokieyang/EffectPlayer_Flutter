// Copyright (c) 2025 Tencent. All rights reserved.
// Autogenerated from Pigeon (v22.7.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon

#import <Foundation/Foundation.h>

@protocol FlutterBinaryMessenger;
@protocol FlutterMessageCodec;
@class FlutterError;
@class FlutterStandardTypedData;

NS_ASSUME_NONNULL_BEGIN

@class FTCEffectConfigMsg;
@class FTCEffectAnimInfoMsg;
@class FMixInfoMsg;
@class FMixItemMsg;
@class FResourceMsg;
@class FTCEffectTextMsg;

/// Pigeon original component, used to generate native communication code for `messages`.
/// The generation command is as follows. When using the generation command,
/// the two import statements above need to be implemented or commented out.
@interface FTCEffectConfigMsg : NSObject
+ (instancetype)makeWithCodecTypeValue:(nullable NSNumber *)codecTypeValue
    freezeFrame:(nullable NSNumber *)freezeFrame
    animTypeValue:(nullable NSNumber *)animTypeValue
    extendMapParams:(nullable NSDictionary *)extendMapParams;
@property(nonatomic, strong, nullable) NSNumber * codecTypeValue;
@property(nonatomic, strong, nullable) NSNumber * freezeFrame;
@property(nonatomic, strong, nullable) NSNumber * animTypeValue;
@property(nonatomic, copy, nullable) NSDictionary * extendMapParams;
@end

@interface FTCEffectAnimInfoMsg : NSObject
+ (instancetype)makeWithType:(nullable NSNumber *)type
    duration:(nullable NSNumber *)duration
    width:(nullable NSNumber *)width
    height:(nullable NSNumber *)height
    encryptLevel:(nullable NSNumber *)encryptLevel
    mixInfo:(nullable FMixInfoMsg *)mixInfo;
@property(nonatomic, strong, nullable) NSNumber * type;
@property(nonatomic, strong, nullable) NSNumber * duration;
@property(nonatomic, strong, nullable) NSNumber * width;
@property(nonatomic, strong, nullable) NSNumber * height;
@property(nonatomic, strong, nullable) NSNumber * encryptLevel;
@property(nonatomic, strong, nullable) FMixInfoMsg * mixInfo;
@end

@interface FMixInfoMsg : NSObject
+ (instancetype)makeWithTextMixItemList:(nullable NSArray<FMixItemMsg *> *)textMixItemList
    imageMixItemList:(nullable NSArray<FMixItemMsg *> *)imageMixItemList;
@property(nonatomic, copy, nullable) NSArray<FMixItemMsg *> * textMixItemList;
@property(nonatomic, copy, nullable) NSArray<FMixItemMsg *> * imageMixItemList;
@end

@interface FMixItemMsg : NSObject
+ (instancetype)makeWithId:(nullable NSString *)id
    tag:(nullable NSString *)tag
    text:(nullable NSString *)text;
@property(nonatomic, copy, nullable) NSString * id;
@property(nonatomic, copy, nullable) NSString * tag;
@property(nonatomic, copy, nullable) NSString * text;
@end

@interface FResourceMsg : NSObject
+ (instancetype)makeWithId:(nullable NSString *)id
    srcType:(nullable NSString *)srcType
    loadType:(nullable NSString *)loadType
    tag:(nullable NSString *)tag
    bitmapByte:(nullable FlutterStandardTypedData *)bitmapByte
    text:(nullable NSString *)text;
@property(nonatomic, copy, nullable) NSString * id;
@property(nonatomic, copy, nullable) NSString * srcType;
@property(nonatomic, copy, nullable) NSString * loadType;
@property(nonatomic, copy, nullable) NSString * tag;
@property(nonatomic, strong, nullable) FlutterStandardTypedData * bitmapByte;
@property(nonatomic, copy, nullable) NSString * text;
@end

@interface FTCEffectTextMsg : NSObject
+ (instancetype)makeWithText:(nullable NSString *)text
    fontStyle:(nullable NSString *)fontStyle
    color:(nullable NSNumber *)color
    alignment:(nullable NSNumber *)alignment
    fontSize:(nullable NSNumber *)fontSize;
@property(nonatomic, copy, nullable) NSString * text;
@property(nonatomic, copy, nullable) NSString * fontStyle;
@property(nonatomic, strong, nullable) NSNumber * color;
@property(nonatomic, strong, nullable) NSNumber * alignment;
@property(nonatomic, strong, nullable) NSNumber * fontSize;
@end

/// The codec used by all APIs.
NSObject<FlutterMessageCodec> *nullGetTCEffectMessagesCodec(void);

@protocol FTCMediaXBaseApi
- (void)setLicenseUrl:(NSString *)url key:(NSString *)key error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setLogEnableEnable:(BOOL)enable error:(FlutterError *_Nullable *_Nonnull)error;
@end

extern void SetUpFTCMediaXBaseApi(id<FlutterBinaryMessenger> binaryMessenger, NSObject<FTCMediaXBaseApi> *_Nullable api);

extern void SetUpFTCMediaXBaseApiWithSuffix(id<FlutterBinaryMessenger> binaryMessenger, NSObject<FTCMediaXBaseApi> *_Nullable api, NSString *messageChannelSuffix);


@protocol FTCEffectAnimViewApi
/// @return `nil` only when `error != nil`.
- (nullable NSNumber *)startPlayPlayUrl:(NSString *)playUrl error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setVideoModeVideoModeValue:(NSInteger)videoModeValue error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setConfigConfig:(FTCEffectConfigMsg *)config error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setScaleTypeScaleTypeValue:(NSInteger)scaleTypeValue error:(FlutterError *_Nullable *_Nonnull)error;
- (void)requestUpdateResourceWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)setRenderRotationRotation:(NSInteger)rotation error:(FlutterError *_Nullable *_Nonnull)error;
/// @return `nil` only when `error != nil`.
- (nullable NSNumber *)isPlayingWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)resumeWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)pauseWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)seekToMilliSec:(NSInteger)milliSec error:(FlutterError *_Nullable *_Nonnull)error;
- (void)seekProgressProgress:(double)progress error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setLoopIsLoop:(BOOL)isLoop error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setLoopCountLoopCount:(NSInteger)loopCount error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setDurationDurationInMilliSec:(NSInteger)durationInMilliSec error:(FlutterError *_Nullable *_Nonnull)error;
- (void)stopPlayClearLastFrame:(BOOL)clearLastFrame error:(FlutterError *_Nullable *_Nonnull)error;
- (void)setMuteMute:(BOOL)mute error:(FlutterError *_Nullable *_Nonnull)error;
/// @return `nil` only when `error != nil`.
- (nullable FTCEffectAnimInfoMsg *)getTCAnimInfoWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)onDestroyWithError:(FlutterError *_Nullable *_Nonnull)error;
- (void)setRateRate:(double)rate error:(FlutterError *_Nullable *_Nonnull)error;
/// @return `nil` only when `error != nil`.
- (nullable NSString *)getSdkVersionWithError:(FlutterError *_Nullable *_Nonnull)error;
@end

extern void SetUpFTCEffectAnimViewApi(id<FlutterBinaryMessenger> binaryMessenger, NSObject<FTCEffectAnimViewApi> *_Nullable api);

extern void SetUpFTCEffectAnimViewApiWithSuffix(id<FlutterBinaryMessenger> binaryMessenger, NSObject<FTCEffectAnimViewApi> *_Nullable api, NSString *messageChannelSuffix);


@interface FTCMediaXBaseFlutterEvent : NSObject
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger;
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger messageChannelSuffix:(nullable NSString *)messageChannelSuffix;
- (void)onLicenseResultErrCode:(NSInteger)errCode msg:(NSString *)msg completion:(void (^)(FlutterError *_Nullable))completion;
@end


@interface FTCEffectAnimViewFlutterEvent : NSObject
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger;
- (instancetype)initWithBinaryMessenger:(id<FlutterBinaryMessenger>)binaryMessenger messageChannelSuffix:(nullable NSString *)messageChannelSuffix;
- (void)fetchImageRes:(FResourceMsg *)res completion:(void (^)(FlutterStandardTypedData *_Nullable, FlutterError *_Nullable))completion;
- (void)fetchTextRes:(FResourceMsg *)res completion:(void (^)(FTCEffectTextMsg *_Nullable, FlutterError *_Nullable))completion;
- (void)releaseResourceResourceList:(NSArray<FResourceMsg *> *)resourceList completion:(void (^)(FlutterError *_Nullable))completion;
- (void)onResClickRes:(FResourceMsg *)res completion:(void (^)(FlutterError *_Nullable))completion;
- (void)onPlayStartWithCompletion:(void (^)(FlutterError *_Nullable))completion;
- (void)onPlayEndWithCompletion:(void (^)(FlutterError *_Nullable))completion;
- (void)onPlayErrorErrCode:(NSInteger)errCode completion:(void (^)(FlutterError *_Nullable))completion;
- (void)onPlayEventEvent:(NSInteger)event param:(NSDictionary *)param completion:(void (^)(FlutterError *_Nullable))completion;
@end

NS_ASSUME_NONNULL_END
